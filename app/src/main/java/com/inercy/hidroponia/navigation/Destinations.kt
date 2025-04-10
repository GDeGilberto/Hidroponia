package com.inercy.hidroponia.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AssuredWorkload
import androidx.compose.material.icons.filled.Home
import androidx.compose.ui.graphics.vector.ImageVector

sealed interface HidroponiaDestination {
    val icon: ImageVector
    val route: String
}

/**
 * App navigation destinations
 */

data object Login : HidroponiaDestination {
    override val icon = Icons.Filled.AssuredWorkload
    override val route = "login"
}

data object Home : HidroponiaDestination {
    override val icon = Icons.Filled.Home
    override val route = "home"
}

data object GreenHouse : HidroponiaDestination {
    override val icon = Icons.Filled.AssuredWorkload
    override val route = "greenhouse"
}