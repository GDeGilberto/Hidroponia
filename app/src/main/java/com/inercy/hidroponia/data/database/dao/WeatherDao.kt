package com.inercy.hidroponia.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update
import com.inercy.hidroponia.data.remote.api.WeatherModel

@Dao
interface WeatherDao {
    @Insert(onConflict = OnConflictStrategy.Companion.IGNORE)
    suspend fun insert(weather: WeatherModel)

    @Update
    suspend fun update(weather: WeatherModel)

    @Delete
    suspend fun delete(weather: WeatherModel)
}