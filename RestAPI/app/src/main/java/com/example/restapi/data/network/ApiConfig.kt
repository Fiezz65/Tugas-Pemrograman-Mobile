package com.example.restapi.data.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

object ApiConfig {
    fun getApiService(): ApiService {
        val contentType = "application/json".toMediaType()
        val json = Json { ignoreUnknownKeys = true }

        val retrofit = Retrofit.Builder()
            .baseUrl("https://mobile-tugas-api.free.beeceptor.com/")
            .addConverterFactory(json.asConverterFactory(contentType))
            .build()

        return retrofit.create(ApiService::class.java)
    }
}