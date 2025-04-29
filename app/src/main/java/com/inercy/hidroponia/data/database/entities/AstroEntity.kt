package com.inercy.hidroponia.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "astro")
data class AstroEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val is_moon_up: Int,
    val is_sun_up: Int,
    val moon_illumination: Int,
    val moon_phase: String,
    val moonrise: String,
    val moonset: String,
    val sunrise: String,
    val sunset: String
)
