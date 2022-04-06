package com.than.tugasramadhan

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Barang::class], version = 1, exportSchema = false)
abstract class BarangDatabase : RoomDatabase() {
    abstract fun barangDao(): BarangDao
    private class WordDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.barangDao())
                }
            }
        }

        suspend fun populateDatabase(barangDao: BarangDao) {
            // Delete all content here.
            barangDao.deleteAll()

            // Add sample words.
            var word = Barang("Hello")
            barangDao.insert(word)
            word = Barang("World!")
            barangDao.insert(word)

            // TODO: Add your own words!
        }
    }

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: BarangDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): BarangDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BarangDatabase::class.java,
                    "barang_database"
                ).addCallback(WordDatabaseCallback(scope)).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}