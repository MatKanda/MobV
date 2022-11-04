package com.example.myapp.database

import android.content.ClipData
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [PubTable::class], version = 1, exportSchema = false)
abstract class PubRoomDatabase: RoomDatabase() {

    abstract fun pubTableDao(): PubTableDao

    companion object {
        @Volatile
        private var INSTANCE: PubRoomDatabase? = null
        fun getDatabase(context: Context): PubRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PubRoomDatabase::class.java,
                    "pub_database"
                ).fallbackToDestructiveMigration().build()
                INSTANCE = instance
                return instance
            }
        }
    }
}