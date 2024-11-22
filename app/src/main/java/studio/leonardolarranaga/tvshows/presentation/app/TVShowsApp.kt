package studio.leonardolarranaga.tvshows.presentation.app

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import studio.leonardolarranaga.tvshows.presentation.navigation.TVShowsNavigation

@Composable
fun TVShowsApp() {
    val navigationController = rememberNavController()
    var canNavigateBack by remember { mutableStateOf(false) }

    navigationController.addOnDestinationChangedListener { _, _, _ ->
        canNavigateBack = navigationController.previousBackStackEntry != null
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = "TV Shows",
                canNavigateBack = canNavigateBack,
                onNavigateBack = { navigationController.popBackStack() }
            )
        },
        bottomBar = {
            BottomNavigationBar(navigationController)
        }
    ) { innerPadding ->
        TVShowsNavigation(
            modifier = Modifier.padding(innerPadding),
            navigationController = navigationController
        )
    }
}



