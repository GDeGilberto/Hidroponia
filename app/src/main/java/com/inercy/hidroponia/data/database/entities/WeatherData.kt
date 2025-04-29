package com.inercy.hidroponia.data.database.entities

import com.inercy.hidroponia.data.remote.api.Current
import com.inercy.hidroponia.data.remote.api.Forecast
import com.inercy.hidroponia.data.remote.api.Location

data class WeatherData(
    val current: Current,
    val forecast: Forecast,
    val location: Location
)
