package studio.leonardolarranaga.tvshows.data.model.tvShow.embededCast

import com.squareup.moshi.Json
import studio.leonardolarranaga.tvshows.data.model.tvShow.shared.Self

data class Links(
    @Json(name = "self")
    val self: Self
)