package com.baha.url.preview

import kotlinx.coroutines.*

class BahaUrlPreview(val url: String, var callback: IUrlPreviewCallback?) {
    val scope = CoroutineScope(Job() + Dispatchers.Main)

    fun fetchUrlPreview(timeOut: Int = 30000) {
        scope.launch {
            fetch(timeOut)
        }
    }

    private suspend fun fetch(timeOut: Int = 30000) {
        val document = get(url, timeOut)
        val urlInfoItem = parseHtml(document)
        urlInfoItem.url = url
        callback?.onComplete(urlInfoItem)
    }

    fun cleanUp() {
        scope.cancel()
        callback = null
    }
}