package studio.leonardolarranaga.tvshows.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import studio.leonardolarranaga.tvshows.data.model.tvShow.TVShow
import studio.leonardolarranaga.tvshows.data.model.tvShow.embededCast.TVShowWithCast
import studio.leonardolarranaga.tvshows.data.model.tvShow.searchTVShow.SearchTVShow

interface TVShowsAPIService {
    @GET("shows")
    suspend fun getTVShows(): Response<List<TVShow>>

    @GET("shows/{id}?embed=cast")
    suspend fun getTVShowById(@Path("id") id: Int): Response<TVShowWithCast>

    @GET("/search/shows")
    suspend fun searchTVShowByName(@Query("q") q: String): Response<List<SearchTVShow>>

}