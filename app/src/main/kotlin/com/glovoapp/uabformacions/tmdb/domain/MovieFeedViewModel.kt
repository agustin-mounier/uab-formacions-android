package com.glovoapp.uabformacions.tmdb.domain

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.glovoapp.uabformacions.tmdb.data.dtos.Movie
import com.glovoapp.uabformacions.tmdb.domain.MovieFeedViewModel.SortingOption.POPULARITY
import com.glovoapp.uabformacions.tmdb.domain.repositories.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieFeedViewModel @Inject constructor(
    private val moviesRepository: MovieRepository
) : ViewModel() {

    private val _movies = MutableStateFlow<List<Movie>>(emptyList())
    val movies: StateFlow<List<Movie>> get() = _movies

    private val _selectedSortingOption = MutableStateFlow(POPULARITY)
    val selectedSortingOption: StateFlow<SortingOption> get() = _selectedSortingOption

    @Inject
    fun init() = viewModelScope.launch {
        _movies.value = moviesRepository.getPopularMovies()
    }

    fun onSortingOptionSelected(sortingOption: SortingOption) {
        _selectedSortingOption.value = sortingOption
    }

    enum class SortingOption(val displayName: String) {
        POPULARITY(displayName = "Popularity"),
        RELEASE_DATE(displayName = "Release Date"),
        RATING(displayName = "Rating")
    }
}
