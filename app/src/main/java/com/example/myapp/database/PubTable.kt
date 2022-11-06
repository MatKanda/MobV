package com.example.myapp.database

import androidx.room.*

//@Entity(tableName = "pub", indices = [Index(value = ["name","latitude","longitude"], unique = true)])
@Entity(tableName = "pub")
data class PubTable(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo(name = "name")
    var pubName: String,
    @ColumnInfo(name = "latitude")
    var longitude: String,
    @ColumnInfo(name = "longitude")
    var latitude: String,
    @ColumnInfo(name = "website")
    var website: String,
    @ColumnInfo(name = "opening_hours")
    var opening_hours: String,
    @ColumnInfo(name = "outdoor_Seating")
    var outdoor_Seating: String){
}