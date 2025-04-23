package com.inercy.hidroponia

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.inercy.hidroponia.ui.navigation.AppDestination
import com.inercy.hidroponia.ui.navigation.AppNavHost
import com.inercy.hidroponia.ui.navigation.AppTopBar
import com.inercy.hidroponia.ui.navigation.ProfileButton
import com.inercy.hidroponia.ui.theme.HidroponiaTheme

@Composable
fun HidroponiaApp() {
    HidroponiaTheme {
        val navController: NavHostController = rememberNavController()
        val backStackEntry by navController.currentBackStackEntryAsState()
        val currentScreen = backStackEntry?.destination?.route

        Scaffold(
            topBar = {
                AppTopBar(
                    currentScreen = currentScreen,
                    canNavigateBack = navController.previousBackStackEntry != null,
                    navigateUp = { navController.navigateUp() },
                    actions = {
                        if (currentScreen != AppDestination.Profile.route) {
                            ProfileButton(navController)
                        }
                    }
                )
            },
            bottomBar = { /* TODO */ }
        ) { innerPadding ->
            AppNavHost(
                navController = navController,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}