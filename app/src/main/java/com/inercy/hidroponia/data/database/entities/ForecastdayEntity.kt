package com.inercy.hidroponia.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "forecastday")
data class ForecastdayEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val idAstro: Int,
    val date: String,
    @SerializedName("date_epoch")
    val dateEpoch: Int,
    val idDay: Int,
    val idHour: List<Int>
)
