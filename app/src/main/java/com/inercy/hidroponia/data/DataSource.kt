package com.inercy.hidroponia.data

import com.inercy.hidroponia.data.model.LogModel
import com.inercy.hidroponia.ui.enums.ApplicationLog

object DataSource {
    val logs = listOf(
        LogModel(
            title = "Plantacion",
            description = "Inicio de la plantacion",
            date = "25-11-2024",
            startTime = "11:00 AM",
            endTime = "12:30 PM",
            responsible = "Juan Perez",
            log = ApplicationLog.CLEAR
        ),
        LogModel(
            title = "Parametros ambientales",
            description = "Actualizacion de parametros ambientales",
            date = "25-11-2024",
            startTime = "09:00 AM",
            endTime = "12:00 PM",
            responsible = "Maria Rodriguez",
            log = ApplicationLog.PARAMETERS
        ),
        LogModel(
            title = "Fumigacion",
            description = "Inicio de la fumigacion",
            date = "06-01-2025",
            startTime = "03:00 PM",
            endTime = "04:30 PM",
            responsible = "Carlos Sanchez",
            log = ApplicationLog.FUMIGATION
        ),
        LogModel(
            title = "Medicion de humedad",
            description = "Medicion de humedad actual",
            date = "07-01-2025",
            startTime = "12:00 PM",
            endTime = "12:30 PM",
            responsible = "Ana Martinez",
            log = ApplicationLog.MEDIC
        )
    )
}