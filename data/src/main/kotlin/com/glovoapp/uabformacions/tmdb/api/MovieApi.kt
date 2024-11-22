package com.glovoapp.uabformacions.tmdb.api

import MoviesResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import retrofit2.http.GET

interface MovieApi {

    @GET("movie/popular")
    suspend fun getPopularMovies(): MoviesResponse

}