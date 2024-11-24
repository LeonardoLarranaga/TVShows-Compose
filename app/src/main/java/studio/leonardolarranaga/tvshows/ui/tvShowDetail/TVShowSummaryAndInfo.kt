package studio.leonardolarranaga.tvshows.ui.tvShowDetail

import android.widget.TextView
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat
import studio.leonardolarranaga.tvshows.data.model.tvShow.embededCast.TVShowWithCast

@Composable
fun TVShowSummaryAndInfo(
    tvShow: TVShowWithCast,
    modifier: Modifier = Modifier
) {
    Column(modifier.padding(horizontal = 16.dp)) {
        Text(
            text = "Summary",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.secondary
        )

        AndroidView(
            factory = { context -> TextView(context) },
            update = {
                it.text = HtmlCompat.fromHtml(tvShow.summary ?: "", HtmlCompat.FROM_HTML_MODE_COMPACT)
                it.setTextAppearance(android.R.style.TextAppearance_Holo)
                it.setTextColor(Color.White.toArgb())
            }
        )

        Row {
            Text(
                text = "Premiered: ",
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.secondary
            )
            Text(
                text = tvShow.premiered,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface
            )

            Spacer(modifier = modifier.weight(1f))

            Text(
                text = "${tvShow.language} ${if (tvShow.network?.country?.name != null) "| ${tvShow.network?.country?.name}" else ""}"
            )
        }
    }
}