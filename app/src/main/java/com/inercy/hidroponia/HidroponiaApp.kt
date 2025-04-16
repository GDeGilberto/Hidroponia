package com.inercy.hidroponia

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.inercy.hidroponia.ui.navigation.AppNavHost
import com.inercy.hidroponia.ui.navigation.AppTopBar
import com.inercy.hidroponia.ui.screens.auth.AuthViewModel
import com.inercy.hidroponia.ui.theme.HidroponiaTheme

@Composable
fun HidroponiaApp(
    authViewModel: AuthViewModel,
    navController: NavHostController = rememberNavController(),
) {

    HidroponiaTheme {
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = backStackEntry?.destination

        Scaffold(
            topBar = {
                AppTopBar(
                    currentScreen = currentRoute?.route,
                    canNavigateBack = navController.previousBackStackEntry != null,
                    navigateUp = { navController.navigateUp() }
                )
            },
            bottomBar = {
                /* TODO */
                // Opcional: Podrías añadir un BottomNavigation aquí
                // usando AppDestination.bottomNavItems
            }
        ) { innerPadding ->
            AppNavHost(
                authViewModel = authViewModel,
                navController = navController,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}