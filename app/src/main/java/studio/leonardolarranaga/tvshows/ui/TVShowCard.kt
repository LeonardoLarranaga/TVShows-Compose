package studio.leonardolarranaga.tvshows.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.util.fastJoinToString
import coil3.compose.rememberAsyncImagePainter
import com.idapgroup.autosizetext.AutoSizeText
import studio.leonardolarranaga.tvshows.data.model.tvShow.TVShow

@Composable
fun TVShowCard(
    modifier: Modifier = Modifier,
    tvShow: TVShow,
    onClick: (Int) -> Unit
) {
    val painter = rememberAsyncImagePainter(tvShow.image?.medium)

    Card(
        modifier = modifier
            .padding(8.dp),
        elevation = CardDefaults.cardElevation(6.dp),
        shape = RoundedCornerShape(16.dp),
        onClick = {
            onClick(tvShow.id)
        }
    ) {
        Box {
            Image(
                painter = painter,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = modifier
                    .height(390.dp)
                    .blur(64.dp)
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = modifier
                    .fillMaxSize()
                    .padding(horizontal = 12.dp)
            ) {
                Image(
                    painter = painter,
                    contentDescription = tvShow.name,
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                        .padding(vertical = 12.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .height(250.dp)
                        .fillMaxWidth()
                )

                AutoSizeText(
                    text = tvShow.name,
                    maxLines = 2,
                    style = MaterialTheme.typography.titleLarge,
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    color = Color.White.copy(alpha = 0.75f)
                )

                Text(
                    text = tvShow.genres.fastJoinToString(),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    color = Color.White.copy(alpha = 0.65f)
                )

                Spacer(modifier.weight(1f))

                TVShowRatingBar(tvShow.rating.average)
            }
        }
    }
}