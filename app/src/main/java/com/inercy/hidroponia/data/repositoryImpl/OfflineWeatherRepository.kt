package com.inercy.hidroponia.data.repositoryImpl

import com.inercy.hidroponia.data.database.dao.WeatherDao
import com.inercy.hidroponia.data.remote.api.WeatherModel
import com.inercy.hidroponia.data.repositories.WeatherRepository

class OfflineWeatherRepository(private val weatherDao: WeatherDao) : WeatherRepository {
    override suspend fun insertWeather(weather: WeatherModel) = weatherDao.insert(weather)
    override suspend fun deleteWeather(weather: WeatherModel) = weatherDao.delete(weather)
    override suspend fun updateWeather(weather: WeatherModel) = weatherDao.update(weather)
}