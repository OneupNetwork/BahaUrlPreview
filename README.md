# BahaUrlPreview
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/tw.com.oneup.www/Baha-UrlPreview/badge.svg)](https://search.maven.org/artifact/tw.com.oneup.www/Baha-UrlPreview)

The library help android developer easier to get url preview info.

100% Kotlin , use Kotlin-coroutines to fetch html code.

Inspire by LeonardoCardoso/SwiftLinkPreview,Android-Link-Preview!

# Demo

https://user-images.githubusercontent.com/11185874/116500622-7e990e80-a8e1-11eb-88b3-3a39ce40cf52.mp4

# How do I use BahaUrlPreview

### Setup
```groovy
//Top-level build.gradle
buildscript {
  ...
    repositories {
      mavenCentral()
      ...
    }
}

//project build.gradle
dependencies {
    ...
    implementation 'tw.com.oneup.www:Baha-UrlPreview:1.0.0'
}
```

### Functions
```Kotlin
val urlPreview = BahaUrlPreview(binding.url.text.toString(), object : IUrlPreviewCallback {
                override fun onComplete(urlInfo: UrlInfoItem) {
                    //urlInfo.title -> is url preivew title
                    //urlInfo.description -> is url preview 
                    //urlInfo.image -> is url preview image
                 }

                override fun onFailed(throwable: Throwable) {
                   // in there control error
                 }
               })

urlPreview.fetchUrlPreview()


//avoid memory leak ,when activity or fragment destory need call BahaUrlPreview.cleanUp()

override fun onDestroy() {
  ...
   urlPreview.cleanUp()
}
```

### Requirements
Android 5.+ (API 21)

### Developed By
OneupNetwork(SolinariWu) 

### License
Copyright (c) 2021 OneupNetwork

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
