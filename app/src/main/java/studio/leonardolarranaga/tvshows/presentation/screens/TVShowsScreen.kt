package studio.leonardolarranaga.tvshows.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import studio.leonardolarranaga.tvshows.data.model.tvShow.TVShow
import studio.leonardolarranaga.tvshows.presentation.screens.viewModels.TVShowsScreenViewModel
import studio.leonardolarranaga.tvshows.ui.ErrorMessage
import studio.leonardolarranaga.tvshows.ui.TVShowCard

@Composable
fun TVShowsScreen(onCardClick: (Int) -> Unit) {
    val viewModel: TVShowsScreenViewModel = viewModel()
    val state by viewModel.state.collectAsState()

    ErrorMessage(
        errorMessage = state.errorMessage,
        onRefresh = viewModel::fetchTVShows
    )

    TVShowsGrid(
        tvShows = state.tvShows,
        onCardClick = onCardClick
    )

    if (state.isLoading)
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) { CircularProgressIndicator() }
}

@Composable
fun TVShowsGrid(
    modifier: Modifier = Modifier,
    tvShows: List<TVShow>,
    onCardClick: (Int) -> Unit,
    isFavorite: Boolean = false,
    onFavoriteClick: (Int) -> Unit = {}
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = modifier
            .fillMaxSize()
            .padding(12.dp)
    ) {
        items(tvShows) { tvShow ->
            TVShowCard(
                tvShow = tvShow,
                onClick = onCardClick,
                isFavorite = isFavorite,
                onFavoriteClick = onFavoriteClick
            )
        }
    }
}