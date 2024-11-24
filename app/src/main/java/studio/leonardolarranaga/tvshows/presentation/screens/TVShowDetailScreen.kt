package studio.leonardolarranaga.tvshows.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastJoinToString
import androidx.lifecycle.viewmodel.compose.viewModel
import studio.leonardolarranaga.tvshows.data.model.tvShow.embededCast.TVShowWithCast
import studio.leonardolarranaga.tvshows.presentation.screens.viewModels.TVShowDetailScreenViewModel
import studio.leonardolarranaga.tvshows.ui.ErrorMessage
import studio.leonardolarranaga.tvshows.ui.TVShowRatingBar
import studio.leonardolarranaga.tvshows.ui.tvShowDetail.TVShowCast
import studio.leonardolarranaga.tvshows.ui.tvShowDetail.TVShowDetailActions
import studio.leonardolarranaga.tvshows.ui.tvShowDetail.TVShowImageBanner
import studio.leonardolarranaga.tvshows.ui.tvShowDetail.TVShowSummaryAndInfo

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
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.verticalScroll(rememberScrollState())
    ) {
        TVShowImageBanner(tvShow = tvShow)

        Text(
            text = tvShow.name,
            style = MaterialTheme.typography.displaySmall,
            fontWeight = FontWeight.Bold
        )

        Text(
            text = "${tvShow.type} | ${tvShow.genres.fastJoinToString()}",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.secondary
        )

        Row(
            modifier = modifier.padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            TVShowRatingBar(
                rating = tvShow.rating.average,
                withWeight = false
            )
            TVShowDetailActions(tvShow = tvShow)
        }

        TVShowSummaryAndInfo(tvShow)

        TVShowCast(tvShow)

        Text(
            text = "Provided by TVMaze",
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.secondaryContainer,
            modifier = modifier.padding(vertical = 8.dp)
        )
    }
}