package com.inercy.hidroponia.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.inercy.hidroponia.ui.screens.GreenHouseScreen
import com.inercy.hidroponia.ui.screens.ProfileScreen
import com.inercy.hidroponia.ui.screens.login.LoginScreen
import com.inercy.hidroponia.ui.screens.HomeScreen

/**
 * NavGraph assigns the composable destinations to be navigated.
 */
@Composable
fun AppNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = AppDestination.Login.route,
        modifier = modifier
    ) {
        composable(route = AppDestination.Login.route) {
            LoginScreen(navController = navController)
        }
        composable(route = AppDestination.Home.route) {
            HomeScreen()
        }
        composable(route = AppDestination.GreenHouse.route) {
            GreenHouseScreen()
        }
        composable(route = AppDestination.Profile.route) {
            ProfileScreen(navController = navController)
        }
    }
}