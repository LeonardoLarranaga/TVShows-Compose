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
            modifier = Modifier
                .padding(
                    start = innerPadding.calculateStartPadding(LocalLayoutDirection.current) - 8.dp,
                    top = innerPadding.calculateTopPadding(),
                    end = innerPadding.calculateEndPadding(LocalLayoutDirection.current),
                    bottom = innerPadding.calculateBottomPadding() - 8.dp
                ),
            navigationController = navigationController
        )
    }
}



