package studio.leonardolarranaga.tvshows.presentation.app.navigation

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import studio.leonardolarranaga.tvshows.presentation.screens.FavoritesScreen
import studio.leonardolarranaga.tvshows.presentation.screens.SearchScreen
import studio.leonardolarranaga.tvshows.presentation.screens.TVShowsScreen

@Composable
fun TVShowsNavigation(
    modifier: Modifier = Modifier,
    navigationController: NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = navigationController,
        startDestination = TVShows,
        enterTransition = { slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.Start) },
        exitTransition = { slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.Start) },
        popEnterTransition = { slideIntoContainer(AnimatedContentTransitionScope.SlideDirection.End) },
        popExitTransition = { slideOutOfContainer(AnimatedContentTransitionScope.SlideDirection.End) }
    ) {

        composable<TVShows> {
            TVShowsScreen()
        }

        composable<Search> {
            SearchScreen()
        }

        composable<Favorites> {
            FavoritesScreen()
        }
    }
}