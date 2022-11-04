package com.example.myapp.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pub")
data class PubTable(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "name")
    val pubName: String,
    @ColumnInfo(name = "latitude")
    val latitude: String,
    @ColumnInfo(name = "website")
    val website: String,
    @ColumnInfo(name = "opening_hours")
    val opening_hours: String,
    @ColumnInfo(name = "outdoor_Seating")
    val outdoor_Seating: String){
}