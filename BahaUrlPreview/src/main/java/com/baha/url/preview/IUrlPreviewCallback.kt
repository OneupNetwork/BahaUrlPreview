package com.baha.url.preview

interface IUrlPreviewCallback {
    fun onComplete(urlInfo: UrlInfoItem)
    fun onFailed(throwable: Throwable)
}