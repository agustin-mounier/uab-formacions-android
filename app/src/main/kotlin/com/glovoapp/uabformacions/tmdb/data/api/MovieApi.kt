package com.glovoapp.uabformacions.tmdb.data.api

import com.glovoapp.uabformacions.tmdb.data.dtos.MoviesResponse
import retrofit2.http.GET

interface MovieApi {

    @GET("movie/popular")
    suspend fun getPopularMovies(): MoviesResponse

}