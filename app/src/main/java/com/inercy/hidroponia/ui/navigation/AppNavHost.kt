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
 * @param authViewModel
 * @param navController
 */
@Composable
fun AppNavHost(
    authViewModel: AuthViewModel,
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Login.route,
        modifier = modifier
    ) {
        composable(route = Login.route) {
            LoginScreen(
                navController = navController,
                authViewModel = authViewModel,
            )
        }
        composable(route = Home.route) {
            HomeScreen(
                navController = navController,
                authViewModel = authViewModel,
            )
        }
        composable(route = GreenHouse.route) {
            GreenHouseScreen()
        }
    }
}