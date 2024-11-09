package com.example.realty.ui.screen.components.filteredProducts

data class FilterSettings(
    var category: String = "Running",
    var orderBy: String = "Popularidad",
    var minPrice: String = "",
    var maxPrice: String = ""
)