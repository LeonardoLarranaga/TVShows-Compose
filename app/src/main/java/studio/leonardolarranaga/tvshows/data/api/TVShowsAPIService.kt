package studio.leonardolarranaga.tvshows.data.api

import retrofit2.Response
import retrofit2.http.GET
import studio.leonardolarranaga.tvshows.data.model.tvShow.TVShow

interface TVShowsAPIService {
    @GET("shows")
    suspend fun getTVShows(): Response<List<TVShow>>
}