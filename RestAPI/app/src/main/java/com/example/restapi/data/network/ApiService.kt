package com.example.restapi.data.network

import com.example.restapi.data.model.BaseResponse
import com.example.restapi.data.model.StudentData
import retrofit2.http.GET

interface ApiService {
    @GET("data")
    suspend fun getStudentData(): BaseResponse<StudentData>
}