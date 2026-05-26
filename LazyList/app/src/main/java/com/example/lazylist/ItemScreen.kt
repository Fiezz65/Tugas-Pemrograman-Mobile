package com.example.lazylist

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ListScreen(items: List<Item>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(top = 32.dp, bottom = 16.dp)
    ) {
        itemsIndexed(items) { index, item ->
            ItemRow(item, index + 1)
        }
    }
}

@Composable
fun ItemRow(item: Item, position: Int) {
    val context = LocalContext.current
    var isChecked by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp, vertical = 6.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = if (position % 2 == 0) Color(0xFFACD1AF) else Color.White
        )
    ) {
        Row(
            modifier = Modifier
                .clickable {
                    isChecked = !isChecked
                    if (!item.isClickToastShown) {
                        Toast.makeText(context, "Item telah ditekan untuk $position", Toast.LENGTH_SHORT).show()
                        item.isClickToastShown = true
                    }
                }
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(65.dp)
                    .background(Color(0xFFF0F0F0), RoundedCornerShape(12.dp))
            ) {
                Icon(
                    painter = painterResource(id = item.imageResId ?: android.R.drawable.ic_menu_gallery),
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.TopCenter).padding(top = 10.dp).size(24.dp),
                    tint = Color.Gray
                )
                Text(
                    text = item.imageLabel,
                    fontSize = 9.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.align(Alignment.BottomCenter).padding(bottom = 8.dp)
                )
            }

            Column(modifier = Modifier.weight(1f).padding(horizontal = 16.dp)) {
                Text(text = item.title, fontSize = 16.sp, fontWeight = FontWeight.Bold)
                Text(text = item.description, fontSize = 14.sp, color = Color.Gray)
            }

            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Switch(
                    checked = isChecked,
                    onCheckedChange = {
                        isChecked = it
                        if (it && !item.isSwitchToastShown) {
                            Toast.makeText(context, "Switch hidup pada item $position", Toast.LENGTH_SHORT).show()
                            item.isSwitchToastShown = true
                        }
                    }
                )
                Button(
                    onClick = {
                        if (!item.isButtonToastShown) {
                            Toast.makeText(context, "Tombol telah ditekan untuk tombol $position", Toast.LENGTH_SHORT).show()
                            item.isButtonToastShown = true
                        }
                    },
                    modifier = Modifier.height(34.dp),
                    shape = RoundedCornerShape(50.dp),
                    contentPadding = PaddingValues(horizontal = 16.dp, vertical = 0.dp)
                ) {
                    Text("Aksi", fontSize = 11.sp)
                }
            }
        }
    }
}