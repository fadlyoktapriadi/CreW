package com.example.crew.ui.screen.NonActive

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.crew.data.db.Anggota
import com.example.crew.di.Injection
import com.example.crew.ui.ViewModelFactory
import com.example.crew.ui.common.UiState
import com.example.crew.ui.components.AnggotaItem

@Composable
fun NonActiveScreen(
    viewModel: NonActiveViewModel = viewModel(
        factory = ViewModelFactory(Injection.provideRepository(context = LocalContext.current))
    ),
) {
    viewModel.uiState.collectAsState(initial = UiState.Loading).value.let { uiState ->
        when (uiState) {
            is UiState.Loading -> {
                viewModel.getAllDataAnggotaNonAktif()
            }
            is UiState.Success -> {
                HomeContent(
                    listAnggota = uiState.data
                )
            }
            is UiState.Error -> {}
        }
    }
}

@Composable
fun HomeContent(
    listAnggota: List<Anggota>,
) {
    Column{
        Text(
            text = "Data Anggota Non Aktif",
            modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp)
        )
        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            modifier = Modifier.padding(8.dp)
        ) {
            items(listAnggota) { anggota ->
                AnggotaItem(
                    kode_anggota = anggota.kode_anggota,
                    nama_anggota = anggota.nama_anggota,
                    tgl_registrasi = anggota.tgl_registrasi,
                    alamat = anggota.alamat,
                    Telepon = anggota.Telepon,
                    Status = anggota.Status
                )
            }
        }
    }
}