package studio.leonardolarranaga.tvshows.data.model.tvShow.embededCast

import com.squareup.moshi.Json

data class Embedded(
    @Json(name = "cast")
    val cast: List<Cast>
)