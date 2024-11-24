package studio.leonardolarranaga.tvshows.data.model.tvShow


import com.squareup.moshi.Json
import studio.leonardolarranaga.tvshows.data.model.tvShow.shared.PreviousEpisode
import studio.leonardolarranaga.tvshows.data.model.tvShow.shared.Self

data class Links(
    @Json(name = "nextepisode")
    val nextepisode: NextEpisode?,
    @Json(name = "previousepisode")
    val previousepisode: PreviousEpisode,
    @Json(name = "self")
    val self: Self
)