package com.example.realty.ui.screen.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun FilteredProducts(
    modifier: Modifier,
    query: String
){
    Text(
        text = "Search -> $query",
        modifier = modifier
    )
}