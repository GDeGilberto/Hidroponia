package com.inercy.hidroponia.ui.navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.inercy.hidroponia.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    title: String,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {}
) {
    TopAppBar(
        title = { Text(title) },
        navigationIcon = {
            if (canNavigateBack) {
                IconButton(onClick = navigateUp) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.back)
                    )
                }
            }
        },
        actions = actions
    )
}

fun getTitleForRoute(route: String?): String {
    return when (route) {
        AppDestination.Home.route -> "Inicio"
        AppDestination.Profile.route -> "Perfil"
        else -> "Mi App"
    }
}

sealed class AppDestination(val route: String) {
    object Home : AppDestination("home")
    object Profile : AppDestination("profile")
    object Settings : AppDestination("settings")
    // Para parámetros:
    data class Detail(val id: Int) : AppDestination("detail/{id}") {
        fun createRoute(id: Int) = "detail/$id"
    }
}