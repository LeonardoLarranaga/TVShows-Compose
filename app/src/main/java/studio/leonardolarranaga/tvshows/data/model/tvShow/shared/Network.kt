package studio.leonardolarranaga.tvshows.data.model.tvShow.shared


import com.squareup.moshi.Json

data class Network(
    @Json(name = "country")
    val country: Country,
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "officialSite")
    val officialSite: String?
)