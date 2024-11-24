package studio.leonardolarranaga.tvshows.presentation.app

import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import studio.leonardolarranaga.tvshows.presentation.app.navigation.BottomNavigationBar
import studio.leonardolarranaga.tvshows.presentation.app.navigation.TVShowsNavigation

@Composable
fun TVShowsApp() {
    val navigationController = rememberNavController()
    var canNavigateBack by remember { mutableStateOf(false) }
    var topBarTitle by remember { mutableStateOf("TV Shows") }

    navigationController.addOnDestinationChangedListener { _, destination, _ ->
        val destinationRoute = destination.route.toString().split(".").last()
        canNavigateBack = navigationController.previousBackStackEntry != null && !listOf("TVShows", "Favorites", "Search").contains(destinationRoute)

        topBarTitle = if (destinationRoute == "TVShows")
            "TV Shows"
        else if (destinationRoute.startsWith("TVShowDetail"))
            ""
        else destinationRoute
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = topBarTitle,
                canNavigateBack = canNavigateBack,
                onNavigateBack = { navigationController.popBackStack() }
            )
        },
        bottomBar = {
            BottomNavigationBar(navigationController)
        }
    ) { innerPadding ->
        TVShowsNavigation(
            modifier = Modifier
                .padding(
                    start = innerPadding.calculateStartPadding(LocalLayoutDirection.current),
                    top = innerPadding.calculateTopPadding(),
                    end = innerPadding.calculateEndPadding(LocalLayoutDirection.current),
                    bottom = innerPadding.calculateBottomPadding() - 8.dp
                ),
            navigationController = navigationController
        )
    }
}