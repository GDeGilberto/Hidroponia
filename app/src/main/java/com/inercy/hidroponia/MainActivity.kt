package com.inercy.hidroponia

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.inercy.hidroponia.ui.screens.modulo.LogBookScreen
import com.inercy.hidroponia.ui.theme.HidroponiaTheme

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HidroponiaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    LogBookScreen(
                        modifier = Modifier
                            .fillMaxHeight()
                            .padding(innerPadding)
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
                    )
                }
            }
        }
    }
}