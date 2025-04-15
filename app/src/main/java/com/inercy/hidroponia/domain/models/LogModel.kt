package com.inercy.hidroponia.domain.models

import com.inercy.hidroponia.utils.enums.ApplicationLog

data class LogModel(
    val title: String,
    val description: String,
    val date: String,
    val startTime: String,
    val endTime: String,
    val responsible: String,
    val log: ApplicationLog
)