package com.example.animelist.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AnimeForm(onSave: (String, String, String, Float, String, Int) -> Unit) {
    var title by remember { mutableStateOf("") }
    var synopsis by remember { mutableStateOf("") }
    var releaseDate by remember { mutableStateOf("") }
    var rating by remember { mutableStateOf("") }
    var watchStatus by remember { mutableStateOf("") }
    var selectedStudioId by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = "Tambah Anime Baru", style = MaterialTheme.typography.titleLarge)
        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Judul Anime") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = synopsis,
            onValueChange = { synopsis = it },
            label = { Text("Sinopsis Singkat") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = releaseDate,
            onValueChange = { releaseDate = it },
            label = { Text("Tanggal Rilis") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = rating,
            onValueChange = { rating = it },
            label = { Text("Rating (Contoh: 8.5)") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = watchStatus,
            onValueChange = { watchStatus = it },
            label = { Text("Status (Selesai/Rencana)") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = selectedStudioId,
            onValueChange = { selectedStudioId = it },
            label = { Text("Masukkan ID Studio") },
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = {
                val parsedRating = rating.toFloatOrNull() ?: 0f
                val parsedStudioId = selectedStudioId.toIntOrNull() ?: 0
                onSave(title, synopsis, releaseDate, parsedRating, watchStatus, parsedStudioId)
                title = ""
                synopsis = ""
                releaseDate = ""
                rating = ""
                watchStatus = ""
                selectedStudioId = ""
            },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Simpan Anime")
        }
    }
}