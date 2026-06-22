package com.example.animelist.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.animelist.database.Anime
import com.example.animelist.database.AnimeWithStudio

@Composable
fun AnimeItem(item: AnimeWithStudio, onDelete: (Anime) -> Unit) {
    Card(modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Judul: ${item.anime.title}", style = MaterialTheme.typography.titleMedium)
            Text(text = "Studio: ${item.studio.studioName}")
            Text(text = "Status: ${item.anime.watchStatus}")
            Text(text = "Rating: ${item.anime.rating}")
            Button(
                onClick = { onDelete(item.anime) },
                modifier = Modifier.padding(top = 8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
            ) {
                Text("Hapus Data")
            }
        }
    }
}