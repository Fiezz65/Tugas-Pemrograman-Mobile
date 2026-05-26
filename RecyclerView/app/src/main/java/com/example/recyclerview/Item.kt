package com.example.recyclerview

data class Item(
    val imageLabel: String,
    val title: String,
    val description: String,
    val imageResId: Int? = null,
    var isClickToastShown: Boolean = false,
    var isSwitchToastShown: Boolean = false,
    var isButtonToastShown: Boolean = false
)