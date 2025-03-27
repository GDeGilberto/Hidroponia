package com.inercy.hidroponia.ui.models

enum class TypeOfMeasurement(val description: String, val symbol: String) {
    TEMPERATURE(description = "Temperatura", symbol = "°C"),
    HUMIDITY(description = "Humedad", symbol = "%"),
    LIGHT_INTENSITY(description = "Luminosidad", symbol = "mol")
}