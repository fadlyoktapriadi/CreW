package com.example.crew.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Anggota::class], version = 1, exportSchema = false)
abstract class CrewDatabase : RoomDatabase() {

    abstract fun crewDao(): CrewDao

    private class CrewDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            INSTANCE?.let { database ->
                scope.launch {
                    populateDatabase(database.crewDao())
                }
            }
        }

        suspend fun populateDatabase(crewDao: CrewDao) {
            // Add initial data here
            val initialAnggota = listOf(
                Anggota(
                    kode_anggota = "OG-2107001",
                    nama_anggota = "Ahmad Sanusi",
                    tgl_registrasi = "13-07-2021",
                    alamat = "Serang",
                    Telepon = "08123456789",
                    Status = "Aktif",
                ),
                Anggota(
                    kode_anggota = "OG-2107002",
                    nama_anggota = "Awaludin",
                    tgl_registrasi = "04-08-2019",
                    alamat = "Jakarta",
                    Telepon = "08123456123",
                    Status = "Aktif",
                ),
                Anggota(
                    kode_anggota = "OG-2107003",
                    nama_anggota = "Rani Amelia",
                    tgl_registrasi = "20-11-2015",
                    alamat = "Bandung",
                    Telepon = "08118156123",
                    Status = "Tidak Aktif",
                ),
                Anggota(
                    kode_anggota = "OG-2107004",
                    nama_anggota = "Reni",
                    tgl_registrasi = "11-11-2018",
                    alamat = "Jakarta",
                    Telepon = "08513436123",
                    Status = "Tidak Aktif",
                ),
                Anggota(
                    kode_anggota = "OG-2107005",
                    nama_anggota = "Cici",
                    tgl_registrasi = "12-06-2011",
                    alamat = "Palembang",
                    Telepon = "08993456123",
                    Status = "Aktif",
                ),
            )
            initialAnggota.forEach { crewDao.insert(it) }
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: CrewDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): CrewDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    CrewDatabase::class.java,
                    "crew_database"
                )
                    .addCallback(CrewDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}