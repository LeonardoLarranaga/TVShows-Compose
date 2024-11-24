package studio.leonardolarranaga.tvshows.data.model.tvShow.shared

import com.squareup.moshi.Json

data class Schedule(
    @Json(name = "days")
    val days: List<String>,
    @Json(name = "time")
    val time: String
)