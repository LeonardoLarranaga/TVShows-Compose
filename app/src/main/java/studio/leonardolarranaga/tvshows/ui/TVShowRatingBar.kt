package studio.leonardolarranaga.tvshows.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun TVShowRatingBar(
    rating: Double?,
    color: Color = Color.White.copy(alpha = 0.55f),
    withWeight: Boolean = true,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        val actualRating = (rating ?: 0f).toFloat()

        Icon(
            imageVector = Icons.Default.ThumbUp,
            contentDescription = null,
            tint = color
        )

        LinearProgressIndicator(
            progress = { actualRating / 10 },
            modifier = if (withWeight) modifier
                .clip(RoundedCornerShape(6.dp))
                .weight(1f)
                .height(5.dp)
            else modifier
                .clip(RoundedCornerShape(6.dp))
                .height(5.dp),
            color = color,
            trackColor = Color.White.copy(alpha = 0.15f)
        )

        Text(
            text = actualRating.toString(),
            maxLines = 1,
            color = color
        )
    }
}