package com.example.recyclerview

object DataSource {
    fun getItemList(): List<Item> {
        return listOf(
            Item("Gambar 1", "Item Pertama", "Deskripsi item kesatu"),
            Item("Gambar 2", "Item Kedua", "Deskripsi item kedua"),
            Item("Gambar 3", "Item Ketiga", "Deskripsi item ketiga"),
            Item("Gambar 4", "Item Keempat", "Deskripsi item keempat"),
            Item("Gambar 5", "Item Kelima", "Deskripsi item kelima"),
            Item("Gambar 6", "Item Keenam", "Deskripsi item keenam"),
            Item("Gambar 7", "Item Ketujuh", "Deskripsi item ketujuh"),
            Item("Gambar 8", "Item Kedelapan", "Deskripsi item kedelapan"),
            Item("Gambar 9", "Item Kesembilan", "Deskripsi item kesembilan"),
            Item("Gambar 10", "Item Kesepuluh", "Deskripsi item kesepuluh")
        )
    }
}