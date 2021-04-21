package com.tochukwu.printfultechnicaltask.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.tochukwu.printfultechnicaltask.data.UnsplashPagingSource
import com.tochukwu.printfultechnicaltask.data.remote.UnsplashApi
import javax.inject.Inject

class UnsplashRepository  @Inject constructor(
    private val unsplashApi: UnsplashApi
) {

    fun getSearchResults(query:String) =
        Pager(
            config = PagingConfig(
                pageSize = 20,
                maxSize = 100,
                enablePlaceholders = false
            ),
            pagingSourceFactory = { UnsplashPagingSource(unsplashApi, query) }
        ).liveData
}