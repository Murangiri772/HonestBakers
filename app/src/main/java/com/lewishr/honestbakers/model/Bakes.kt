package com.lewishr.honestbakers.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bakes")
data class Bakes(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val price: Double,

    val imagePath: String
)