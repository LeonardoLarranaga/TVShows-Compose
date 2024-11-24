package studio.leonardolarranaga.tvshows.data.model.tvShow.embededCast

import com.squareup.moshi.Json

data class Cast(
    @Json(name = "character")
    val character: Character,
    @Json(name = "person")
    val person: Person,
    @Json(name = "self")
    val self: Boolean,
    @Json(name = "voice")
    val voice: Boolean
)