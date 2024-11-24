package studio.leonardolarranaga.tvshows.data.model.tvShow.searchTVShow

import com.squareup.moshi.Json
import studio.leonardolarranaga.tvshows.data.model.tvShow.TVShow

data class SearchTVShow(
    @Json(name = "score")
    val score: Double,
    @Json(name = "show")
    val tvShow: TVShow
)