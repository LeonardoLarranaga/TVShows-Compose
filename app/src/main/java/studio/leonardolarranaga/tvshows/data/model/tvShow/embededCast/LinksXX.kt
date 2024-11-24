package studio.leonardolarranaga.tvshows.data.model.tvShow.embededCast

import com.squareup.moshi.Json
import studio.leonardolarranaga.tvshows.data.model.tvShow.shared.PreviousEpisode
import studio.leonardolarranaga.tvshows.data.model.tvShow.shared.Self

data class LinksXX(
    @Json(name = "previousepisode")
    val previousepisode: PreviousEpisode,
    @Json(name = "self")
    val self: Self
)