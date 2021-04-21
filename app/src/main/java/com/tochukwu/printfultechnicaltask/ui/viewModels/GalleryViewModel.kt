package com.tochukwu.printfultechnicaltask.ui.viewModels

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import androidx.paging.cachedIn
import com.tochukwu.printfultechnicaltask.repository.UnsplashRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class GalleryViewModel   @Inject constructor(
    private val repository: UnsplashRepository,
    @Assisted state: SavedStateHandle
): ViewModel() {


    companion object {
        private const val DEFAULT_QUERY = "cats"
        private const val CURRENT_QUERY = "current_query"
    }

    private val currentQuery = state.getLiveData(CURRENT_QUERY, DEFAULT_QUERY)


    val photos = currentQuery.switchMap { queryString ->
        repository.getSearchResults(queryString).cachedIn(viewModelScope)
    }

    fun searchPhotos(query: String) {
        currentQuery.value = query

    }
}