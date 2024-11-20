package com.glovoapp.uabformacions.tmdb

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.glovoapp.uabformacions.tmdb.api.MovieApi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class MovieFeedViewModel @Inject constructor(
    private val movieApi: MovieApi,
) : ViewModel() {

    val movies = MutableStateFlow<List<MovieApi.Movie>>(emptyList())

    @Inject
    fun init() = viewModelScope.launch {
        movies.value = movieApi.getPopularMovies().results.sortedByDescending { it.popularity }
    }

    fun onSortingOptionSelected(sortingOption: String) {
        when (sortingOption) {
            "Popularity" -> {
                movies.value = movies.value.sortedByDescending { it.popularity }
            }

            "Release date" -> {
                movies.value = movies.value.sortedByDescending { LocalDate.parse(it.releaseDate) }
            }

            "Rating" -> {
                movies.value = movies.value.sortedByDescending { it.voteAverage }
            }
        }
    }

}
