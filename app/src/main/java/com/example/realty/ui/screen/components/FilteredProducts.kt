package com.example.realty.ui.screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FilteredProducts(
    modifier: Modifier,
    query: String
){
    Text(
        text = "Search -> $query",
        modifier = modifier
    )
@Composable
fun Header() {
    Column {
        Text(text = "Headphone", fontSize = 16.sp, color = Color.Gray)
        Text(text = "TMA Wireless", fontSize = 24.sp, fontWeight = FontWeight.Bold)
    }
}