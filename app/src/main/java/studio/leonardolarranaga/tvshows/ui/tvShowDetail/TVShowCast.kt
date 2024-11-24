package studio.leonardolarranaga.tvshows.ui.tvShowDetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import studio.leonardolarranaga.tvshows.data.model.tvShow.embededCast.TVShowWithCast

@Composable
fun TVShowCast(
    tvShow: TVShowWithCast,
    modifier: Modifier = Modifier
) {
    Column {
        Text(
            text = "Cast",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.secondary,
            modifier = modifier.padding(start = 16.dp, top = 16.dp)
        )

        LazyRow {
            items(tvShow.embedded.cast) { character ->
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = modifier.padding(horizontal = 8.dp)
                ) {
                    AsyncImage(
                        model = character.person.image.medium,
                        contentDescription = character.person.name,
                        contentScale = ContentScale.Crop,
                        modifier = modifier
                            .size(95.dp)
                            .clip(CircleShape)
                    )

                    Text(
                        text = character.person.name,
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )

                    Text(
                        text = character.character.name,
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.surfaceTint.copy(alpha = 0.55f)
                    )
                }
            }
        }
    }
}