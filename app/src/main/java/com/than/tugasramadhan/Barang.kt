package com.than.tugasramadhan

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "barang")
data class Barang(@PrimaryKey @ColumnInfo(name = "nama_barang") val nama_barang: String)
