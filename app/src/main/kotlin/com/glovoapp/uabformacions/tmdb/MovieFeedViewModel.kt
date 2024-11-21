package com.glovoapp.uabformacions.tmdb

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.glovoapp.uabformacions.tmdb.api.MovieApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class MovieFeedViewModel @Inject constructor(
    private val movieApi: MovieApi,
) : ViewModel() {

    private val _movies = MutableStateFlow<List<MovieApi.Movie>>(emptyList())
    val movies: StateFlow<List<MovieApi.Movie>> get() = _movies

    @Inject
    fun init() = viewModelScope.launch {
        _movies.value = movieApi.getPopularMovies().results.sortedByDescending { it.popularity }
    }

    fun onSortingOptionSelected(sortingOption: String) {
        _movies.value = when (sortingOption) {
            "Popularity" -> _movies.value.sortedByDescending { it.popularity }
            "Release Date" -> _movies.value.sortedByDescending { LocalDate.parse(it.releaseDate) }
            "Rating" -> _movies.value.sortedByDescending { it.voteAverage }
            else -> _movies.value
        }
    }
}
