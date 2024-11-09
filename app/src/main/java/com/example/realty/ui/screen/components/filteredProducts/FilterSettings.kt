package com.example.realty.ui.screen.components.filteredProducts

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf

data class FilterSettings(
    var category: MutableState<String> = mutableStateOf(""),
    var orderBy: MutableState<String> = mutableStateOf(""),
    var minPrice: MutableState<Int> = mutableStateOf(0),
    var maxPrice: MutableState<Int> = mutableStateOf(1000),
)