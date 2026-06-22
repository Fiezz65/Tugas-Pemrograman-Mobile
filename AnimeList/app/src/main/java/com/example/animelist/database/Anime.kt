package com.example.animelist.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "anime_table",
    foreignKeys = [
        ForeignKey(
            entity = Studio::class,
            parentColumns = ["studio_id"],
            childColumns = ["studio_id"],
            onDelete = ForeignKey.CASCADE,
            onUpdate = ForeignKey.CASCADE
        )
    ]
)
data class Anime(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "anime_id")
    val animeId: Int = 0,
    val title: String,
    val synopsis: String,
    @ColumnInfo(name = "release_date")
    val releaseDate: String,
    val rating: Float,
    @ColumnInfo(name = "watch_status")
    val watchStatus: String,
    @ColumnInfo(name = "studio_id")
    val studioId: Int
)