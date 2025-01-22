package com.example.crew.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "anggota")
data class Anggota(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val kode_anggota: String,
    val nama_anggota: String,
    val tgl_registrasi: String,
    val alamat: String,
    val Telepon: String,
    val Status: String,
)