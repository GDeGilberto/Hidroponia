package com.inercy.hidroponia

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.inercy.hidroponia.ui.navigation.AppNavHost
import com.inercy.hidroponia.ui.navigation.AppTopBar
import com.inercy.hidroponia.ui.navigation.getTitleForRoute
import com.inercy.hidroponia.ui.theme.HidroponiaTheme

@Composable
fun HidroponiaApp() {
    HidroponiaTheme {
        val navController = rememberNavController()
        val backStackEntry by navController.currentBackStackEntryAsState()

        Scaffold(
            topBar = {
                AppTopBar(
                    title = getTitleForRoute(backStackEntry?.destination?.route),
                    canNavigateBack = navController.previousBackStackEntry != null,
                    navigateUp = { navController.navigateUp() }
                )
            }
        ) { innerPadding ->
            AppNavHost(
                navController = navController,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}