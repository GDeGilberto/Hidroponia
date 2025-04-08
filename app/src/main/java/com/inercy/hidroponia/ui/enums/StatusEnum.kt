package com.inercy.hidroponia.ui.enums

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Warning
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.inercy.hidroponia.ui.theme.*

enum class StatusEnum(val id: Int, val color: Color, val colorLight: Color, val icon: ImageVector) {
    OK(id = 1, color = GreenBase2, colorLight = GreenSubtle, icon = Icons.Filled.CheckCircle),
    Warning(id = 2, color = YellowDarker, colorLight = YellowSubtle, icon = Icons.Filled.Warning),
    Error(id = 3, color = RedDarker, colorLight = RedSubtle, icon = Icons.Filled.Close),
    Information(id = 4, color = BlueDarker, colorLight = BlueSubtle, icon = Icons.Filled.Info),
}