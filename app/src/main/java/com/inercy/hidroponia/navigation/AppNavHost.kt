package com.inercy.hidroponia.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.inercy.hidroponia.ui.screens.GreenHouseScreen
import com.inercy.hidroponia.ui.screens.home.HidroponiaHomeScreen

/**
 * NavGraph realiza la asignacion de los destinos composable a los que se navegara
 * @param navController Clase con el objetivo de navegar entre pantallas
 * @param startDestination Es una ruta de predeterminada cuando la app muestra por primera vez
 */
@Composable
fun AppNavHost(
    navController: NavHostController,
    startDestination: String = Home.route,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Home.route,
        modifier = modifier
    ) {
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