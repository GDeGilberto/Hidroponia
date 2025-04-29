package com.inercy.hidroponia.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "forecastday")
data class ForecastdayEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val idAstro: Int,
    val date: String,
    val date_epoch: Int,
    val idDay: Int,
    val idHour: List<Int>
)
