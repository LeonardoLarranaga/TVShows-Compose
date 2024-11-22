package studio.leonardolarranaga.tvshows.data.model.tvShow


import com.squareup.moshi.Json

data class Rating(
    @Json(name = "average")
    val average: Double?
)