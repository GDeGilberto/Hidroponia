package com.inercy.hidroponia.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.inercy.hidroponia.ui.screens.GreenHouseScreen
import com.inercy.hidroponia.ui.screens.LoginScreen
import com.inercy.hidroponia.ui.screens.home.HidroponiaHomeScreen

/**
 * NavGraph assigns the composable destinations to be navigated.
 * @param navController "Class designed for screen navigation
 * @param startDestination It is a default route when the app is displayed for the first time
 */
@Composable
fun AppNavHost(
    navController: NavHostController,
    startDestination: String = Login.route,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(route = Login.route) {
            LoginScreen(
                onLoginClick = { _, _ ->
                    navController.navigate(Home.route)
                }
            )
        }
        composable(route = Home.route) {
            HidroponiaHomeScreen(
                navigateTo = { navController.navigate(GreenHouse.route) },
            )
        }
        composable(route = GreenHouse.route) {
            GreenHouseScreen()
        }
    }
}