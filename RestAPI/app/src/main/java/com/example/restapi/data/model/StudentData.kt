package com.example.restapi.data.model

import kotlinx.serialization.Serializable

@Serializable
data class StudentData(
    val id: String,
    val nama: String,
    val status: String
)