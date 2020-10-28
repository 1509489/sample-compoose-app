package com.pixelart.composesample

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.Text
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.platform.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.*
import androidx.ui.tooling.preview.Preview
import com.pixelart.composesample.ui.NavigationRoute
import com.pixelart.composesample.ui.calender.Calender
import com.pixelart.composesample.ui.favorite.Favorite
import com.pixelart.composesample.ui.home.Home
import com.pixelart.composesample.ui.profile.Profile
import com.pixelart.composesample.ui.theme.ComposeSampleTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeSampleTheme(darkTheme = false) {
                Scaffolding()
            }
        }
    }
}

@Composable
fun Scaffolding() {
    val context = ContextAmbient.current
    val navController = rememberNavController()

    Scaffold(
        topBar = { TopAppBar(title = { Text(text = "Compose sample") }) },
        bottomBar = { BottomNavBar(navController) },
        floatingActionButtonPosition = FabPosition.End,
        isFloatingActionButtonDocked = false,
        floatingActionButton = {
            FloatingActionButton(
                shape = CircleShape,
                onClick = { Toast.makeText(context, "Add Clicked", Toast.LENGTH_SHORT).show() },
                backgroundColor = MaterialTheme.colors.primary
            ) {
                Icon(asset = Icons.Filled.Add, tint = MaterialTheme.colors.onPrimary)
            }
        }
    ) {
        NavHost(navController, startDestination = NavigationRoute.Home.route) {
            composable(NavigationRoute.Home.route) { Home(navController = navController) }
            composable(NavigationRoute.Calender.route) { Calender(navController = navController) }
            composable(NavigationRoute.Favorite.route) { Favorite(navController = navController) }
            composable(NavigationRoute.Profile.route) { Profile(navController = navController) }
        }
    }
}

@Composable
fun BottomNavBar(navController: NavHostController) {
    val navItems = listOf(
        NavigationRoute.Home,
        NavigationRoute.Calender,
        NavigationRoute.Favorite,
        NavigationRoute.Profile
    )

    BottomNavigation(
        backgroundColor = MaterialTheme.colors.primary
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.arguments?.getString(KEY_ROUTE)

        navItems.forEach { navigationRoute ->
            BottomNavigationItem(
                icon = { Icon(asset = navigationRoute.icon) },
                selected = currentRoute == navigationRoute.route,
                onClick = {
                    // This is the equivalent to popUpTo the start destination
                    navController.popBackStack(navController.graph.startDestination, false)

                    // This if check gives us a "singleTop" behavior where we do not create a
                    // second instance of the composable if we are already on that destination
                    if (currentRoute != navigationRoute.route) {
                        navController.navigate(navigationRoute.route)
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val navController = rememberNavController()

    ComposeSampleTheme {
        Scaffold(
            topBar = { TopAppBar(title = { Text(text = "Compose sample") }) },
            bottomBar = { BottomNavBar(navController) },
            floatingActionButtonPosition = FabPosition.End,
            isFloatingActionButtonDocked = false,
            floatingActionButton = {
                FloatingActionButton(
                    shape = CircleShape,
                    onClick = {},
                    backgroundColor = MaterialTheme.colors.primary
                ) {
                    Icon(asset = Icons.Filled.Add, tint = MaterialTheme.colors.onPrimary)
                }
            }
        ) {

        }
    }
}