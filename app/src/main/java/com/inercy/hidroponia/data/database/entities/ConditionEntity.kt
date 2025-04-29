package com.inercy.hidroponia.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "condition")
data class ConditionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val code: Int,
    val icon: String,
    val text: String
)
