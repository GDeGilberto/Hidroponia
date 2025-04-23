package com.inercy.hidroponia.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.inercy.hidroponia.ui.screens.GreenHouseScreen
import com.inercy.hidroponia.ui.screens.auth.AuthViewModel
import com.inercy.hidroponia.ui.screens.auth.LoginScreen
import com.inercy.hidroponia.ui.screens.home.HomeScreen

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
            HomeScreen(
                navController = navController,
                authViewModel = authViewModel,
            )
        }
        composable(route = AppDestination.GreenHouse.route) {
            GreenHouseScreen()
        }
    }
}