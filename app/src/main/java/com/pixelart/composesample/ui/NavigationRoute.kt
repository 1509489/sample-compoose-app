package com.pixelart.composesample.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.VectorAsset

sealed class NavigationRoute(val route: String, val icon: VectorAsset) {
    object Home: NavigationRoute(route = Route.Home.name, icon = Icons.Filled.Home)
    object Calender: NavigationRoute(route = Route.Calender.name, icon = Icons.Filled.DateRange)
    object Favorite: NavigationRoute(route = Route.Favorite.name, icon = Icons.Filled.Favorite)
    object Profile: NavigationRoute(route = Route.Profile.name, icon = Icons.Filled.Person)
}

enum class Route {
    Home, Calender, Favorite, Profile
}