package studio.leonardolarranaga.tvshows.data.model.tvShow.embededCast

import com.squareup.moshi.Json
import studio.leonardolarranaga.tvshows.data.model.tvShow.shared.Image

data class Character(
    @Json(name = "id")
    val id: Int,
    @Json(name = "image")
    val image: Image?,
    @Json(name = "_links")
    val links: Links,
    @Json(name = "name")
    val name: String,
    @Json(name = "url")
    val url: String
)