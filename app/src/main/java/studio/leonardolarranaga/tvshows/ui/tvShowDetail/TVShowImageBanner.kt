package studio.leonardolarranaga.tvshows.ui.tvShowDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil3.compose.rememberAsyncImagePainter
import studio.leonardolarranaga.tvshows.data.model.tvShow.embededCast.TVShowWithCast

@Composable
fun TVShowImageBanner(
    modifier: Modifier = Modifier,
    tvShow: TVShowWithCast
) {
    val painter = rememberAsyncImagePainter(tvShow.image.original)

    Box(
        contentAlignment = Alignment.TopCenter,
        modifier = Modifier
            .height(320.dp)
    ) {
        Image(
            painter = painter,
            contentDescription = tvShow.name,
            contentScale = ContentScale.Crop,
            modifier = modifier
                .fillMaxWidth()
                .height(225.dp)
                .blur(128.dp)
        )

        Image(
            painter = painter,
            contentDescription = tvShow.name,
            modifier = modifier
                .fillMaxWidth(0.45f)
                .padding(vertical = 12.dp)
                .shadow(
                    elevation = 16.dp,
                    spotColor = Color.White.copy(alpha = 0.3f),
                    ambientColor = Color.Blue
                )
        )
    }
}