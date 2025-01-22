package com.example.crew.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.crew.R

@Composable
fun AnggotaItem(
     kode_anggota: String,
     nama_anggota: String,
     tgl_registrasi: String,
     alamat: String,
     Telepon: String,
     Status: String
){
    ElevatedCard(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
        modifier = Modifier.fillMaxWidth(),
        onClick = { }
    ) {
        Column (
            modifier = Modifier.padding(16.dp)
        ) {
            ElevatedCard(
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                ),
                colors = CardDefaults.cardColors(
                    containerColor = Color(0xFFA9FF89),
                ),
                modifier = Modifier
                    .size(width = 60.dp, height = 25.dp)
            ) {
                Row(
                    modifier = Modifier
                        .padding(4.dp)
                        .align(Alignment.CenterHorizontally)

                ) {
                    Text(
                        text = Status,
                        style = MaterialTheme.typography.bodySmall,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black,
                    )
                }
            }
            Text(
                text = stringResource(R.string.kode_anggota, kode_anggota),
                style = MaterialTheme.typography.bodySmall,
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(4.dp)
            )
            Text(
                text = stringResource(R.string.nama_anggota, nama_anggota),
                style = MaterialTheme.typography.bodySmall,
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(4.dp)
            )
            Text(
                text = stringResource(R.string.tgl_registrasi, tgl_registrasi),
                style = MaterialTheme.typography.bodySmall,
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(4.dp)
            )
            Text(
                text = stringResource(R.string.alamat_anggota, alamat),
                style = MaterialTheme.typography.bodySmall,
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(4.dp)
            )
            Text(
                text = stringResource(R.string.no_telp, Telepon),
                style = MaterialTheme.typography.bodySmall,
                fontSize = 12.sp,
                fontWeight = FontWeight.Normal,
                color = Color.Black,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                modifier = Modifier.padding(4.dp)
            )
        }
    }
}



@Composable
@Preview(showBackground = true)
fun AnggotaItemPreview() {
    AnggotaItem(
        kode_anggota = "OG-2107001",
        nama_anggota = "Ahmad Sanusi",
        tgl_registrasi = "13-07-2021",
        alamat = "Serang",
        Telepon = "08123456789",
        Status = "Aktif",
    )
}