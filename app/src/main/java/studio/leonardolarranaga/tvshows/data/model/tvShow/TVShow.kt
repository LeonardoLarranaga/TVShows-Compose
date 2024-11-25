package studio.leonardolarranaga.tvshows.data.model.tvShow

import androidx.room.Entity
import androidx.room.PrimaryKey
import studio.leonardolarranaga.tvshows.data.model.tvShow.shared.Image
import studio.leonardolarranaga.tvshows.data.model.tvShow.shared.Rating


@Entity
data class TVShow(
    @PrimaryKey val id: Int,
    val name: String,
    val image: Image?,
    val rating: Rating,
    val genres: List<String>,
)