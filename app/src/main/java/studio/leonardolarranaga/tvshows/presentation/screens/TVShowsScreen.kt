package studio.leonardolarranaga.tvshows.presentation.screens

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import studio.leonardolarranaga.tvshows.presentation.screens.viewModels.TVShowsScreenViewModel

@Composable
fun TVShowsScreen(modifier: Modifier = Modifier) {
    val viewModel: TVShowsScreenViewModel = viewModel()
    val state by viewModel.state.collectAsState()

    if (state.isLoading) {
        Text("Loading...")
    } else if (state.errorMessage != null) {
        Text("Error: ${state.errorMessage}")
    } else if (state.tvShows.isNotEmpty()) {
        Text(state.tvShows.toString())
    } else {
        Text(":(")
    }
}