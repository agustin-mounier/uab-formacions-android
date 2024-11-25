package com.glovoapp.uabformacions.tmdb.domain.repositories

import com.glovoapp.uabformacions.tmdb.data.api.MovieApi
import com.glovoapp.uabformacions.tmdb.data.dtos.Movie
import javax.inject.Inject

class MovieRepository @Inject constructor(
    private val movieApi: MovieApi
) {

    // In-memory cache for the movie list
    private var cachedMovies: List<Movie>? = null

    /**
     * Fetches popular movies. If the data is already cached, return it; otherwise, fetch from the API.
     */
    suspend fun getPopularMovies(forceRefresh: Boolean = false): List<Movie> {
        return if (!forceRefresh && cachedMovies != null) {
            // Return cached data
            cachedMovies!!
        } else {
            // Fetch from API and update the cache
            val response = movieApi.getPopularMovies()
            cachedMovies = response.results
            cachedMovies!!
        }
    }

    /**
     * Clears the in-memory cache.
     */
    fun clearCache() {
        cachedMovies = null
    }
}

