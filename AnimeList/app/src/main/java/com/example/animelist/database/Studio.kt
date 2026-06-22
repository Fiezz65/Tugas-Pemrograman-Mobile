package com.example.animelist.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "studio_table")
data class Studio(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "studio_id")
    val studioId: Int = 0,
    @ColumnInfo(name = "studio_name")
    val studioName: String,
    @ColumnInfo(name = "founded_year")
    val foundedYear: String
)