package com.lewishr.honestbakers.model



import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "messages")
data class Message(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val sender: String,
    val text: String,
    val timestamp: Long = System.currentTimeMillis()
)
