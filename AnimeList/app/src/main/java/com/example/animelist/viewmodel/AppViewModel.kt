package com.example.animelist.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.animelist.database.Anime
import com.example.animelist.database.AppDatabase
import com.example.animelist.database.Studio
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class AppViewModel(application: Application) : AndroidViewModel(application) {
    private val dao = AppDatabase.getDatabase(application).animeDao()

    val studios = dao.getAllStudios().stateIn(viewModelScope, SharingStarted.Lazily, emptyList())
    val animes = dao.getAllAnimeWithStudio().stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun addStudio(name: String, year: String) {
        viewModelScope.launch {
            dao.insertStudio(Studio(studioName = name, foundedYear = year))
        }
    }

    fun addAnime(title: String, synopsis: String, date: String, rating: Float, status: String, studioId: Int) {
        viewModelScope.launch {
            dao.insertAnime(
                Anime(
                    title = title,
                    synopsis = synopsis,
                    releaseDate = date,
                    rating = rating,
                    watchStatus = status,
                    studioId = studioId
                )
            )
        }
    }

    fun deleteAnime(anime: Anime) {
        viewModelScope.launch {
            dao.deleteAnime(anime)
        }
    }
}