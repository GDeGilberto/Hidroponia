package com.inercy.hidroponia.ui.navigation

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.inercy.hidroponia.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    currentScreen: String?,
    canNavigateBack: Boolean,
    navigateUp: () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {}
) {
    val destination = AppDestination.allDestinations.find { it.route == currentScreen }
    val showBackButton = destination?.showBackButton == true && canNavigateBack

    TopAppBar(
        title = { Text(text = AppDestination.getTitleForRoute(currentScreen)) },
        navigationIcon = {
            if (showBackButton) { BackButton(navigateUp) }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.surface,
            titleContentColor = MaterialTheme.colorScheme.onSurface,
            actionIconContentColor = MaterialTheme.colorScheme.onSurface,
        ),
        actions = actions
    )
}

@Composable
fun BackButton(navigateUp: () -> Unit = {}) {
    IconButton(onClick = navigateUp) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = stringResource(R.string.back),
            tint = MaterialTheme.colorScheme.onSurface
        )
    }
}

@Composable
fun ProfileButton(navController: NavController) {
    IconButton(onClick = { navController.navigate(AppDestination.Profile.route) }) {
        Icon(
            imageVector = Icons.Default.Person, // Necesitarás importar Icons.Default.Person
            contentDescription = "Perfil",
            tint = MaterialTheme.colorScheme.onSurface
        )
    }
}