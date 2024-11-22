package studio.leonardolarranaga.tvshows.presentation.app.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavHostController
import studio.leonardolarranaga.tvshows.R

data class BottomNavigationItem<T: Any>(val title: String, val route: T, val icon: ImageVector)

@Composable
fun BottomNavigationBar(
    navigationController: NavHostController
) {
    val items = listOf(
        BottomNavigationItem(
            title = "TV Shows",
            route = TVShows,
            icon = ImageVector.vectorResource(id = R.drawable.tv)
        ),
        BottomNavigationItem(
            title = "Search",
            route = Search,
            icon = Icons.Filled.Search
        ),
        BottomNavigationItem(
            title = "Favorites",
            route = Favorites,
            icon = Icons.Default.Star
        )
    )

    var selectedItem by remember { mutableStateOf(items[0]) }

    NavigationBar {
        items.forEach { item ->
            NavigationBarItem(
                icon = { Icon(item.icon, contentDescription = item.title) },
                selected = selectedItem == item,
                label = { Text(item.title) },
                onClick = {
                    if (selectedItem == item) return@NavigationBarItem
                    selectedItem = item
                    navigationController.navigate(item.route) {
                        popUpTo(navigationController.graph.startDestinationId) {
                            inclusive = false
                        }
                        launchSingleTop = true
                    }
                },
            )
        }
    }
}