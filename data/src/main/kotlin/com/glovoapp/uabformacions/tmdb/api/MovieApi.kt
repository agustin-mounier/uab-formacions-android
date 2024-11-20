package com.glovoapp.uabformacions.tmdb.api

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import retrofit2.http.GET

interface MovieApi {

    @GET("movie/popular")
    suspend fun getPopularMovies(): MoviesResponse

    @Serializable
    data class MoviesResponse(
        val page: Int,
        val results: List<Movie>,
        @SerialName("total_pages") val totalPages: Int,
        @SerialName("total_results") val totalResults: Int
    )

    @Serializable
    data class Movie(
        val adult: Boolean,
        @SerialName("backdrop_path") val backdropPath: String,
        @SerialName("genre_ids") val genreIds: List<Int>,
        val id: Long,
        @SerialName("original_language") val originalLanguage: String,
        @SerialName("original_title") val originalTitle: String,
        val overview: String,
        val popularity: Double,
        @SerialName("poster_path") val posterPath: String,
        @SerialName("release_date") val releaseDate: String,
        val title: String,
        val video: Boolean,
        @SerialName("vote_average") val voteAverage: Float,
        @SerialName("vote_count") val voteCount: Long
    )

}