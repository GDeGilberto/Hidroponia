package com.inercy.hidroponia.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AssuredWorkload
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Lock
import androidx.compose.ui.graphics.vector.ImageVector

sealed class AppDestination(
    val route: String,
    val icon: ImageVector? = null,
    val title: String,
    val showInNavigation: Boolean = true,
    val showBackButton: Boolean = true
) {
    object Login : AppDestination(
        route = "login",
        icon = Icons.Filled.Lock,
        title = "Inicio de sesion",
        showInNavigation = false,
        showBackButton = false
    )
    object Profile : AppDestination(
        route = "profile",
        icon = Icons.Filled.Lock,
        title = "Perfil",
        showBackButton = true
    )
    object Home : AppDestination(
        route = "Home",
        icon = Icons.Filled.Home,
        title = "Inicio",
        showBackButton = false
    )
    object GreenHouse : AppDestination(
        route = "greenhouse",
        icon = Icons.Filled.AssuredWorkload,
        title = "Invernadero",
        showBackButton = true
    )


    data class Details(val id: Int = -1) : AppDestination(
        route = "details/$id",
        title = "Details",
        showInNavigation = false
    ) {
        fun createRoute(id: Int) = "details/$id"
    }


    companion object {
        val bottomNavItems = listOf(Home, GreenHouse)
        val allDestinations = listOf(Login, Home, GreenHouse, Details())

        fun getTitleForRoute(route: String?): String {
            return allDestinations.find { it.route == route ||
                    (it is Details && route?.startsWith("detail/") == true) }?.title ?: "Hidroponia"
        }
    }
}