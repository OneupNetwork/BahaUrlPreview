package com.baha.url.preview.sample

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.baha.url.preview.BahaUrlPreview
import com.baha.url.preview.IUrlPreviewCallback
import com.baha.url.preview.UrlInfoItem
import com.baha.url.preview.sample.databinding.ActivityMainBinding
import com.bumptech.glide.Glide

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var urlPreview: BahaUrlPreview

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.preview.setOnClickListener {
            if (binding.url.text.isNotEmpty()) {
                binding.previewGroup.visibility = View.GONE
                binding.progressBar.visibility = View.VISIBLE
                urlPreview =
                    BahaUrlPreview(binding.url.text.toString(), object : IUrlPreviewCallback {
                        override fun onComplete(urlInfo: UrlInfoItem) {
                            binding.previewGroup.visibility = View.VISIBLE
                            binding.progressBar.visibility = View.GONE
                            binding.title.text = urlInfo.title
                            binding.description.text = urlInfo.description
                            Glide.with(this@MainActivity)
                                .load(urlInfo.image)
                                .into(binding.image)
                        }

                        override fun onFailed(throwable: Throwable) {
                            throwable.printStackTrace()
                            Toast.makeText(
                                this@MainActivity,
                                "url preview failed!",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    })

                urlPreview.fetchUrlPreview()
            }
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        if (this::urlPreview.isInitialized) {
            urlPreview.cleanUp()
        }
    }
}