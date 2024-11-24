package studio.leonardolarranaga.tvshows.data.model.tvShow.embededCast

import com.squareup.moshi.Json
import studio.leonardolarranaga.tvshows.data.model.tvShow.shared.Image
import studio.leonardolarranaga.tvshows.data.model.tvShow.shared.Country

data class Person(
    @Json(name = "birthday")
    val birthday: String?,
    @Json(name = "country")
    val country: Country?,
    @Json(name = "deathday")
    val deathday: Any?,
    @Json(name = "gender")
    val gender: String?,
    @Json(name = "id")
    val id: Int,
    @Json(name = "image")
    val image: Image,
    @Json(name = "_links")
    val links: Links,
    @Json(name = "name")
    val name: String,
    @Json(name = "updated")
    val updated: Int,
    @Json(name = "url")
    val url: String
)