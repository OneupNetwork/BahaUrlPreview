package com.baha.url.preview

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UrlInfoItem(
    var url: String = "",
    var title: String = "",
    var description: String = "",
    var image: String = ""
) : Parcelable {

    fun allFetchComplete(): Boolean {
        return title.isNotEmpty() && description.isNotEmpty() && image.isNotEmpty()
    }
}