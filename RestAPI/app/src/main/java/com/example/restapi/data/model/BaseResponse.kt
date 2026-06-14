package com.example.restapi.data.model

import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse<T>(
    val message: String,
    val code: String,
    val data: T
)