package studio.leonardolarranaga.tvshows.data.model.tvShow.shared


import com.squareup.moshi.Json

data class Image(
    @Json(name = "medium")
    val medium: String,
    @Json(name = "original")
    val original: String
)