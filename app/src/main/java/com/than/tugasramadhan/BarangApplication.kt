package com.than.tugasramadhan

import android.app.Application
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

class BarangApplication: Application() {
    val applicationScope = CoroutineScope(SupervisorJob())
    val database by lazy { BarangDatabase.getDatabase(this, applicationScope) }
    val repository by lazy { BarangRepository(database.barangDao()) }
}