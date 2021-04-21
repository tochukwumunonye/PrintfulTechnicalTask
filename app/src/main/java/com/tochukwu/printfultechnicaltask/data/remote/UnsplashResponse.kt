package com.tochukwu.printfultechnicaltask.data.remote

import com.tochukwu.printfultechnicaltask.data.UnsplashPhoto

data class UnsplashResponse(
    val results: List<UnsplashPhoto>
) {
}