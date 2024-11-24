package studio.leonardolarranaga.tvshows.data.model.tvShow


import com.squareup.moshi.Json
import studio.leonardolarranaga.tvshows.data.model.tvShow.shared.Country

data class WebChannel(
    @Json(name = "country")
    val country: Country?,
    @Json(name = "id")
    val id: Int,
    @Json(name = "name")
    val name: String,
    @Json(name = "officialSite")
    val officialSite: String?
)