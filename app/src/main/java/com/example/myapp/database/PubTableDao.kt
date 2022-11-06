package com.example.myapp.database

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface PubTableDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(pubTable: PubTable):Long

    @Update
    suspend fun update(pubTable: PubTable)

    @Delete
    suspend fun delete(pubTable: PubTable)

    @Query("DELETE from pub")
    suspend fun deleteAll()

    @Query("SELECT * from pub WHERE id = :id")
    fun getItem(id: Int): Flow<PubTable>

    @Query("SELECT * from pub ORDER BY name ASC")
    fun getItems(): Flow<List<PubTable>>

}