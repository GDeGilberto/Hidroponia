package com.inercy.hidroponia.utils.enums

enum class TypeOfMeasurement(val description: String, val symbol: String) {
    TEMPERATURE(description = "Temperatura", symbol = "°C"),
    HUMIDITY(description = "Humedad", symbol = "%"),
    LIGHT_INTENSITY(description = "Luminosidad", symbol = "mol")
}