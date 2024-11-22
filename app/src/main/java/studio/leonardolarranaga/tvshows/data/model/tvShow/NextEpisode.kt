package studio.leonardolarranaga.tvshows.data.model.tvShow


import com.squareup.moshi.Json

data class NextEpisode(
    @Json(name = "href")
    val href: String,
    @Json(name = "name")
    val name: String
)