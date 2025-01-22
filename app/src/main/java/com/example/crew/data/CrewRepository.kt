package com.example.crew.data

import android.content.Context
import com.example.crew.data.db.Anggota
import com.example.crew.data.db.CrewDao
import com.example.crew.data.db.CrewDatabase
import kotlinx.coroutines.CoroutineScope


class CrewRepository(context: Context, scope: CoroutineScope) {
    private val crewDao: CrewDao = CrewDatabase.getDatabase(context, scope).crewDao()

    suspend fun insertAnggota(anggota: Anggota) {
        crewDao.insert(anggota)
    }

    suspend fun getAllAnggota(): List<Anggota> {
        return crewDao.getAllAnggota()
    }

    companion object {
        @Volatile
        private var instance: CrewRepository? = null

        fun getInstance(context: Context, scope: CoroutineScope): CrewRepository =
            instance ?: synchronized(this) {
                CrewRepository(context, scope).apply {
                    instance = this
                }
            }
    }
}