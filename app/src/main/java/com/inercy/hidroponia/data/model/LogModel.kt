package com.inercy.hidroponia.data.model

import com.inercy.hidroponia.ui.enums.ApplicationLog

data class LogModel(
    val title: String,
    val description: String,
    val date: String,
    val startTime: String,
    val endTime: String,
    val responsible: String,
    val log: ApplicationLog
)