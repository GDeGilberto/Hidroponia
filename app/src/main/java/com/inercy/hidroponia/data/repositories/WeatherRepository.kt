package com.inercy.hidroponia.data.repositories

import com.inercy.hidroponia.data.remote.api.WeatherModel

/**
 * Repository that provides insert, update, delete, and retrieve of
 * [WeatherModel] from a given data source.
 */
interface WeatherRepository {
    /**
     * Insert item in the data source
     */
    suspend fun insertWeather(weather: WeatherModel)

    /**
     * Delete item from the data source
     */
    suspend fun deleteWeather(weather: WeatherModel)

    /**
     * Update item in the data source
     */
    suspend fun updateWeather(weather: WeatherModel)
}