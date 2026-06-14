package com.example.restapi.ui

import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.restapi.R

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvResult = findViewById<TextView>(R.id.tv_result)

        viewModel.resultText.observe(this) { text ->
            tvResult.text = text
        }

        viewModel.fetchStudentData()
    }
}