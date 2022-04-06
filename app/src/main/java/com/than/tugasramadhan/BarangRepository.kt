package com.than.tugasramadhan

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class BarangRepository(private val barangDao: BarangDao) {
    // Room executes all queries on a separate thread.
    // Observed Flow will notify the observer when the data has changed.
    val allBarang: Flow<List<Barang>> = barangDao.getAllBarang()

    // By default Room runs suspend queries off the main thread, therefore, we don't need to
    // implement anything else to ensure we're not doing long running database work
    // off the main thread.
    @Suppress("RedundantSuspendModifier")
    @WorkerThread
    suspend fun insert(barang: Barang) {
        barangDao.insert(barang)
    }
}