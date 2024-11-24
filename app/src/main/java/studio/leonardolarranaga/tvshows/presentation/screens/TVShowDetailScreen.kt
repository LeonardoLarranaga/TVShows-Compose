package studio.leonardolarranaga.tvshows.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import studio.leonardolarranaga.tvshows.data.model.tvShow.embededCast.TVShowWithCast
import studio.leonardolarranaga.tvshows.presentation.screens.viewModels.TVShowDetailScreenViewModel
import studio.leonardolarranaga.tvshows.ui.ErrorMessage

@Composable
fun TVShowDetailScreen(modifier: Modifier = Modifier) {
    val viewModel: TVShowDetailScreenViewModel = viewModel()
    val state by viewModel.state.collectAsState()

    ErrorMessage(
        errorMessage = state.errorMessage,
        onRefresh = viewModel::fetchTVShow
    )

    if (state.tvShow != null)
        TVShowDetailContent(
            modifier = modifier,
            tvShow = state.tvShow!!
        )

    if (state.isLoading)
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) { CircularProgressIndicator() }
}

@Composable
fun TVShowDetailContent(
    modifier: Modifier = Modifier,
    tvShow: TVShowWithCast
) {
    Text(tvShow.toString())
}