package com.example.animelist.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow

@Dao
interface AnimeDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertStudio(studio: Studio)

    @Delete
    suspend fun deleteStudio(studio: Studio)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAnime(anime: Anime)

    @Delete
    suspend fun deleteAnime(anime: Anime)

    @Transaction
    @Query("SELECT * FROM anime_table")
    fun getAllAnimeWithStudio(): Flow<List<AnimeWithStudio>>

    @Query("SELECT * FROM studio_table")
    fun getAllStudios(): Flow<List<Studio>>
}