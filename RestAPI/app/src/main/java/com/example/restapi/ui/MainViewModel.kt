package com.example.restapi.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.restapi.data.network.ApiConfig
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    private val _resultText = MutableLiveData<String>()
    val resultText: LiveData<String> = _resultText

    fun fetchStudentData() {
        viewModelScope.launch {
            try {
                val response = ApiConfig.getApiService().getStudentData()

                val formattedText = """
                    Status API: ${response.message} (Code: ${response.code})
                    
                    Data Mahasiswa:
                    NIM: ${response.data.id}
                    Nama: ${response.data.nama}
                    Status: ${response.data.status}
                """.trimIndent()

                _resultText.value = formattedText
            } catch (e: Exception) {
                _resultText.value = "Terjadi kesalahan koneksi:\n${e.message}"
            }
        }
    }
}