package com.example.animelist.database

import androidx.room.Embedded
import androidx.room.Relation

data class AnimeWithStudio(
    @Embedded val anime: Anime,
    @Relation(
        parentColumn = "studio_id",
        entityColumn = "studio_id"
    )
    val studio: Studio
)