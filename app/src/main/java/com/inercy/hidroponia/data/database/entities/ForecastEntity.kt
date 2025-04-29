package com.inercy.hidroponia.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.inercy.hidroponia.data.remote.api.Forecastday

@Entity(tableName = "forecast")
data class ForecastEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val forecastday: List<Forecastday>
)
