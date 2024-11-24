package studio.leonardolarranaga.tvshows.data.model.tvShow.shared

import com.squareup.moshi.Json

data class Country(
    @Json(name = "code")
    val code: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "timezone")
    val timezone: String
)