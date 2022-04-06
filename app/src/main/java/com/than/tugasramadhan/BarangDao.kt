package com.than.tugasramadhan

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface BarangDao {
    @Query("SELECT * FROM barang ORDER BY nama_barang ASC")
    fun getAllBarang(): Flow<List<Barang>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(barang: Barang)

    @Query("DELETE FROM barang")
    suspend fun deleteAll()
}