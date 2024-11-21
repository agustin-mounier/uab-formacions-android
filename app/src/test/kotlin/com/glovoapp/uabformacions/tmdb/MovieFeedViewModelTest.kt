package com.glovoapp.uabformacions.tmdb

import com.glovoapp.uabformacions.tmdb.api.MovieApi
import io.mockk.coEvery
import io.mockk.mockk
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class MovieFeedViewModelTest {

    private lateinit var viewModel: MovieFeedViewModel
    private val movieApi: MovieApi = mockk()

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @Before
    fun setup() {
        val mockMovies = generateListOfMovies()

        coEvery { movieApi.getPopularMovies() } returns MovieApi.MoviesResponse(
            page = 1, results = mockMovies, totalPages = 2, totalResults = 3
        )

        viewModel = MovieFeedViewModel(movieApi)
        viewModel.init()
    }

    @Test
    fun `should load and sort movies by popularity by default`() = runTest {
        advanceUntilIdle() // Ensure the coroutine completes

        val movies = viewModel.movies.value
        assertEquals(3, movies.size)
        assertEquals(70.0, movies[0].popularity)
        assertEquals(50.0, movies[1].popularity)
        assertEquals(40.0, movies[2].popularity)
    }

    @Test
    fun `should sort movies by release date`() = runTest {
        advanceUntilIdle() // Ensure the coroutine completes

        viewModel.onSortingOptionSelected("Release Date")
        val movies = viewModel.movies.value

        assertEquals("2023-10-01", movies[0].releaseDate)
        assertEquals("2023-01-01", movies[1].releaseDate)
        assertEquals("2022-01-01", movies[2].releaseDate)
    }

    @Test
    fun `should sort movies by rating`() = runTest {
        advanceUntilIdle() // Ensure the coroutine completes

        viewModel.onSortingOptionSelected("Rating")
        val movies = viewModel.movies.value

        assertEquals(8.6f, movies[0].voteAverage)
        assertEquals(8.0f, movies[1].voteAverage)
        assertEquals(7.5f, movies[2].voteAverage)
    }

    private fun generateListOfMovies() = listOf(
        MovieApi.Movie(
            adult = false,
            backdropPath = "path1",
            genreIds = listOf(1, 2),
            id = 1L,
            originalLanguage = "en",
            originalTitle = "Movie 1",
            overview = "Overview 1",
            popularity = 50.0,
            posterPath = "poster1",
            releaseDate = "2022-01-01",
            title = "Movie 1",
            video = false,
            voteAverage = 7.5f,
            voteCount = 100
        ), MovieApi.Movie(
            adult = false,
            backdropPath = "path2",
            genreIds = listOf(3, 4),
            id = 2L,
            originalLanguage = "en",
            originalTitle = "Movie 2",
            overview = "Overview 2",
            popularity = 70.0,
            posterPath = "poster2",
            releaseDate = "2023-01-01",
            title = "Movie 2",
            video = false,
            voteAverage = 8.0f,
            voteCount = 200
        ), MovieApi.Movie(
            adult = false,
            backdropPath = "path3",
            genreIds = listOf(3, 4),
            id = 3L,
            originalLanguage = "en",
            originalTitle = "Movie 3",
            overview = "Overview 3",
            popularity = 40.0,
            posterPath = "poster3",
            releaseDate = "2023-10-01",
            title = "Movie 3",
            video = false,
            voteAverage = 8.6f,
            voteCount = 200
        )
    )
}
