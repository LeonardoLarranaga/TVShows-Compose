package studio.leonardolarranaga.tvshows

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import studio.leonardolarranaga.tvshows.presentation.app.TVShowsApp
import studio.leonardolarranaga.tvshows.ui.theme.TVShowsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TVShowsTheme {
                TVShowsApp()
            }
        }
    }
}