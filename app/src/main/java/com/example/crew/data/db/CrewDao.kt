package com.example.crew.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface CrewDao {
    @Insert
    suspend fun insert(anggota: Anggota)

    @Query("SELECT * FROM anggota WHERE Status = 'Aktif'")
    suspend fun getAllAnggota(): List<Anggota>

    @Query("SELECT * FROM anggota WHERE Status = 'Tidak Aktif'")
    suspend fun getAllAnggotaNonAktif(): List<Anggota>
}