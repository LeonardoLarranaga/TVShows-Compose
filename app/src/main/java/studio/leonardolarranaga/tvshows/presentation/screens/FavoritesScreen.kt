package studio.leonardolarranaga.tvshows.presentation.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.lifecycle.viewmodel.compose.viewModel
import studio.leonardolarranaga.tvshows.presentation.screens.viewModels.FavoritesScreenViewModel

@Composable
fun FavoritesScreen(
    onCardClick: (Int) -> Unit,
) {
    val viewModel: FavoritesScreenViewModel = viewModel(factory = FavoritesScreenViewModel.Factory)
    val state = viewModel.state.collectAsState()

    TVShowsGrid(
        tvShows = state.value.favorites,
        onCardClick = onCardClick,
        isFavorite = true,
        onFavoriteClick = { tvShowId ->
            viewModel.removeFavorite(tvShowId)
        }
    )
}