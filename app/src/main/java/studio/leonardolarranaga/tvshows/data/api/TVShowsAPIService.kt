package studio.leonardolarranaga.tvshows.data.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import studio.leonardolarranaga.tvshows.data.model.tvShow.TVShow
import studio.leonardolarranaga.tvshows.data.model.tvShow.embededCast.TVShowWithCast

interface TVShowsAPIService {
    @GET("shows")
    suspend fun getTVShows(): Response<List<TVShow>>

    @GET("shows/{id}?embed=cast")
    suspend fun getTVShowById(@Path("id") id: Int): Response<TVShowWithCast>
}