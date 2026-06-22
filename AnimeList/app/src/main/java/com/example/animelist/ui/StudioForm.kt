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
fun StudioForm(onSave: (String, String) -> Unit) {
    var studioName by remember { mutableStateOf("") }
    var foundedYear by remember { mutableStateOf("") }

    Column(modifier = Modifier.fillMaxWidth()) {
        Text(text = "Tambah Studio Baru", style = MaterialTheme.typography.titleLarge)
        OutlinedTextField(
            value = studioName,
            onValueChange = { studioName = it },
            label = { Text("Nama Studio") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = foundedYear,
            onValueChange = { foundedYear = it },
            label = { Text("Tahun Berdiri") },
            modifier = Modifier.fillMaxWidth()
        )
        Button(
            onClick = {
                onSave(studioName, foundedYear)
                studioName = ""
                foundedYear = ""
            },
            modifier = Modifier.padding(top = 8.dp)
        ) {
            Text("Simpan Studio")
        }
    }
}