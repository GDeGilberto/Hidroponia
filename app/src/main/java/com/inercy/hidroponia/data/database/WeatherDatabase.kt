package com.inercy.hidroponia.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.inercy.hidroponia.data.database.dao.WeatherDao
import com.inercy.hidroponia.data.database.entities.AstroEntity
import com.inercy.hidroponia.data.database.entities.ConditionEntity
import com.inercy.hidroponia.data.database.entities.CurrentEntity
import com.inercy.hidroponia.data.database.entities.DayEntity
import com.inercy.hidroponia.data.database.entities.ForecastdayEntity
import com.inercy.hidroponia.data.database.entities.HourEntity
import com.inercy.hidroponia.data.database.entities.LocationEntity
import com.inercy.hidroponia.data.remote.api.WeatherModel

@Database(entities = [
    AstroEntity::class,
    ConditionEntity::class,
    CurrentEntity::class,
    DayEntity::class,
    ForecastdayEntity::class,
    HourEntity::class,
    LocationEntity::class
                     ], version = 1, exportSchema = false)
abstract class WeatherDatabase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao

    companion object {
        const val DATABASE_NAME = "weather_database"

        @Volatile
        private var Instance: WeatherDatabase? = null

        fun getDatabase(context: Context): WeatherDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, WeatherDatabase::class.java, DATABASE_NAME)
                    .build()
                    .also { Instance = it }
            }
        }
    }
}