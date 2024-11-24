package studio.leonardolarranaga.tvshows.ui.tvShowDetail

import android.content.Intent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import studio.leonardolarranaga.tvshows.R
import studio.leonardolarranaga.tvshows.data.model.tvShow.embededCast.TVShowWithCast

@Composable
fun TVShowDetailActions(
    tvShow: TVShowWithCast,
    modifier: Modifier = Modifier
) {
    val isFavorite by remember { mutableStateOf(false) }
    val context = LocalContext.current

    Row(modifier.padding(start = 12.dp)) {
        IconButton(onClick = {}) {
            Icon(
                imageVector = if (isFavorite) Icons.Filled.Star else ImageVector.vectorResource(R.drawable.star_border),
                contentDescription = "Mark/Unmark as Favorite",
                tint = if (isFavorite) MaterialTheme.colorScheme.surfaceTint else MaterialTheme.colorScheme.onSurface
            )
        }

        IconButton(onClick = {
            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                putExtra(Intent.EXTRA_TEXT, tvShow.url.toString())
                type = "text/plain"
            }

            context.startActivity(Intent.createChooser(shareIntent, null))
        }) {
            Icon(
                imageVector = Icons.Default.Share,
                contentDescription = "Share"
            )
        }
    }
}