package studio.leonardolarranaga.tvshows.data.model.tvShow.shared


import com.squareup.moshi.Json

data class Rating(
    @Json(name = "average")
    val average: Double?
)