package studio.leonardolarranaga.tvshows.data.model.tvShow.shared


import com.squareup.moshi.Json
import studio.leonardolarranaga.tvshows.data.model.tvShow.NextEpisode

data class Links(
    @Json(name = "nextepisode")
    val nextepisode: NextEpisode?,
    @Json(name = "previousepisode")
    val previousepisode: PreviousEpisode?,
    @Json(name = "self")
    val self: Self?
)