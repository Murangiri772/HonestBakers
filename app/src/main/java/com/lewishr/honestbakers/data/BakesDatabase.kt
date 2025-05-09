package com.lewishr.honestbakers.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.lewishr.honestbakers.model.Bakes
import com.lewishr.honestbakers.model.User


@Database(entities = [Bakes::class, User::class], version = 3, exportSchema = false)
abstract class BakesDatabase : RoomDatabase() {
    abstract fun bakesDao(): BakesDao
    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE:BakesDatabase? = null

        fun getDatabase(context: Context): BakesDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BakesDatabase::class.java,
                    "main_database"
                )
                    .fallbackToDestructiveMigration() // 💥 This clears DB on version change
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}