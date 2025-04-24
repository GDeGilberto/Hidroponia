package com.inercy.hidroponia.data.remote.api

data class WeatherModel(
    val current: Current,
    val forecast: Forecast,
    val location: Location
)