package studio.leonardolarranaga.tvshows.data.model.tvShow.shared


import com.squareup.moshi.Json

data class Externals(
    @Json(name = "imdb")
    val imdb: String?,
    @Json(name = "thetvdb")
    val thetvdb: Int?,
    @Json(name = "tvrage")
    val tvrage: Int?
)