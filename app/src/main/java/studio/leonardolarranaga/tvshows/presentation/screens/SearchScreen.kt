package studio.leonardolarranaga.tvshows.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import studio.leonardolarranaga.tvshows.R
import studio.leonardolarranaga.tvshows.presentation.screens.viewModels.SearchScreenViewModel
import studio.leonardolarranaga.tvshows.ui.ErrorMessage

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    onCardClick: (Int) -> Unit
) {
    val viewModel: SearchScreenViewModel = viewModel()
    val state by viewModel.state.collectAsState()

    val keyboardController = LocalSoftwareKeyboardController.current

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        ErrorMessage(
            errorMessage = state.errorMessage,
            onRefresh = viewModel::searchTVShowByName
        )

        Box(modifier.weight(1f)) {
            if (state.tvShows.isEmpty()) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(if (state.hasSearched) R.drawable.tv_off else R.drawable.tv),
                        contentDescription = "Search",
                        modifier = modifier
                            .fillMaxSize(0.5f),
                        tint = MaterialTheme.colorScheme.surfaceTint.copy(alpha = 0.55f)
                    )

                    if (state.hasSearched)
                        Text(
                            text = "No TV shows found.",
                        )
                }

            } else {
                TVShowsGrid(
                    tvShows = state.tvShows.map { it.tvShow },
                    onCardClick = onCardClick,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(bottom = 22.dp)
                .padding(horizontal = 12.dp)
        ) {
            OutlinedTextField(
                value = state.searchText,
                onValueChange = viewModel::updateSearchText,
                label = { Text("Search TV Shows...") },
                modifier = modifier.weight(1f),
                singleLine = true,
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Search
                ),
                keyboardActions = KeyboardActions(
                    onSearch = {
                        if (state.searchText.trim().isNotEmpty() && !state.isLoading) {
                            keyboardController?.hide()
                            viewModel.searchTVShowByName()
                        }
                    }
                ),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = "Search"
                    )
                }
            )
        }
    }

    if (state.isLoading)
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) { CircularProgressIndicator() }
}