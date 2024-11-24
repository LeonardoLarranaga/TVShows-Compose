package studio.leonardolarranaga.tvshows.data.model.tvShow.shared


import com.squareup.moshi.Json

data class Self(
    @Json(name = "href")
    val href: String
)