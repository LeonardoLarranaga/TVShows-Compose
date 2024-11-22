package studio.leonardolarranaga.tvshows.data.model.tvShow


import com.squareup.moshi.Json

data class Links(
    @Json(name = "nextepisode")
    val nextepisode: NextEpisode?,
    @Json(name = "previousepisode")
    val previousepisode: PreviousEpisode,
    @Json(name = "self")
    val self: Self
)