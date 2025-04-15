package com.inercy.hidroponia.utils.enums

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Assignment
import androidx.compose.material.icons.filled.BugReport
import androidx.compose.material.icons.filled.CleaningServices
import androidx.compose.material.icons.filled.Medication
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.inercy.hidroponia.ui.theme.BlueBase
import com.inercy.hidroponia.ui.theme.PurpleBase
import com.inercy.hidroponia.ui.theme.TealDarker
import com.inercy.hidroponia.ui.theme.YellowDarker

enum class ApplicationLog(
    val id: Int,
    val icon: ImageVector,
    val color: Color
) {
    MEDIC(id = 1, icon = Icons.Filled.Medication, color = BlueBase),
    FUMIGATION(id = 2, icon = Icons.Filled.BugReport, color = YellowDarker),
    CLEAR(id = 3, icon = Icons.Filled.CleaningServices, color = TealDarker),
    PARAMETERS(id = 4, icon = Icons.AutoMirrored.Filled.Assignment, color = PurpleBase)
}