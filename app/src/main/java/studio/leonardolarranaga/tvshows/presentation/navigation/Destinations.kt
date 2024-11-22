package studio.leonardolarranaga.tvshows.presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
object TVShows

@Serializable
data class TVShowDetail(val tvShowId: Int)

@Serializable
object Search

@Serializable
object Favorites