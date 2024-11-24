package studio.leonardolarranaga.tvshows.data.model.tvShow.shared


import com.squareup.moshi.Json

data class PreviousEpisode(
    @Json(name = "href")
    val href: String,
    @Json(name = "name")
    val name: String
)