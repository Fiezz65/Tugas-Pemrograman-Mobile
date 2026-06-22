package com.example.animelist.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.animelist.viewmodel.AppViewModel

@Composable
fun MainScreen(viewModel: AppViewModel = viewModel()) {
    val studios by viewModel.studios.collectAsState()
    val animes by viewModel.animes.collectAsState()
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
        StudioForm(
            onSave = { name, year -> viewModel.addStudio(name, year) }
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(text = "Referensi ID Studio", style = MaterialTheme.typography.titleMedium)
        studios.forEach { studio ->
            Text(text = "ID: ${studio.studioId} - Nama: ${studio.studioName}")
        }

        Spacer(modifier = Modifier.height(24.dp))

        AnimeForm(
            onSave = { title, synopsis, date, rating, status, studioId ->
                viewModel.addAnime(title, synopsis, date, rating, status, studioId)
            }
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(text = "Daftar Anime Saya", style = MaterialTheme.typography.titleLarge)
        animes.forEach { item ->
            AnimeItem(
                item = item,
                onDelete = { anime -> viewModel.deleteAnime(anime) }
            )
        }
    }
}