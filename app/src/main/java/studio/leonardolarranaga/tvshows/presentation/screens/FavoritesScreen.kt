package studio.leonardolarranaga.tvshows.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.lifecycle.viewmodel.compose.viewModel
import studio.leonardolarranaga.tvshows.R
import studio.leonardolarranaga.tvshows.presentation.screens.viewModels.FavoritesScreenViewModel

@Composable
fun FavoritesScreen(
    onCardClick: (Int) -> Unit,
) {
    val viewModel: FavoritesScreenViewModel = viewModel(factory = FavoritesScreenViewModel.Factory)
    val state = viewModel.state.collectAsState()

    if (state.value.favorites.isEmpty())
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.star_slash),
                contentDescription = "No Favorites",
                modifier = Modifier
                    .fillMaxSize(0.5f),
                tint = MaterialTheme.colorScheme.surfaceTint.copy(alpha = 0.55f)
            )
            Text("No favorites yet.")
        }
    else
        TVShowsGrid(
            tvShows = state.value.favorites,
            onCardClick = onCardClick,
            isFavorite = true,
            onFavoriteClick = { tvShowId ->
                viewModel.removeFavorite(tvShowId)
            }
        )
}