package com.example.realty.ui.screen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.realty.data.Product

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

@Composable
fun FilterOptions() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        Button(onClick = {}, colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray)) {
            Text(text = "Filter")
        }
        Text(text = "Popularity", modifier = Modifier.clickable { /* Do nothing for now */ })
        Text(text = "Newest", modifier = Modifier.clickable { /* Do nothing for now */ })
        Text(text = "Most Expensive", modifier = Modifier.clickable { /* Do nothing for now */ })
    }

@Composable
fun RatingBar(rating: Float, reviews: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        /*
        Icon(
            painter = painterResource(id = R.drawable.ic_star),
            contentDescription = "Rating",
            tint = Color(0xFFFFD700),
            modifier = Modifier.size(16.dp)
        )
        */
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = "$rating", fontSize = 14.sp)
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = "($reviews Reviews)", fontSize = 12.sp, color = Color.Gray)
    }
}