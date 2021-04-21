package com.tochukwu.printfultechnicaltask.data.remote

import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface UnsplashApi {


    companion object {
        const val CLIENT_ID = "TPTSPX8iuU4Et8CJkWUaHFqfIEQ655JBpSOW_oiIEwA"
        const val  BASE_URL = "https://api.unsplash.com/"

    }


    @Headers("Accept-Version:v1", "Authorization: Client-ID $CLIENT_ID")
    @GET("search/photos")
    suspend fun searchPhotos(
        @Query("query") query: String,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): UnsplashResponse
}