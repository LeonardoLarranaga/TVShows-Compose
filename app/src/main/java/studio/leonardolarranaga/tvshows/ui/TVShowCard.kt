package studio.leonardolarranaga.tvshows.ui

import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import studio.leonardolarranaga.tvshows.data.model.tvShow.TVShow

@Composable
fun TVShowCard(
    modifier: Modifier = Modifier,
    tvShow: TVShow
) {
    Card {
        Text(
            tvShow.toString())
    }
}