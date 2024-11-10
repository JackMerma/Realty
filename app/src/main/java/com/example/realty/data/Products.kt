package com.example.realty.data
import com.example.realty.R

// Main product class
data class Product(
    val name: String,
    val price: Float,
    val rating: Float,
    val reviews: Int,
    val imageId: Int
)

val sample_product_id = R.drawable.shoes

// Defining sample products
val productList = listOf(
    Product("Tensaur Sport Training", 100f, 4.6f, 86, sample_product_id),
    Product("Tensaur Sport Training", 100f, 4.6f, 86, sample_product_id),
    Product("Tensaur Sport Training", 100f, 4.6f, 86, sample_product_id),
    Product("Tensaur Sport Training", 100f, 4.6f, 86, sample_product_id),
    Product("Tensaur Sport Training", 100f, 4.6f, 86, sample_product_id),
    Product("Tensaur Sport Training", 100f, 4.6f, 86, sample_product_id),
    Product("Tensaur Sport Training", 100f, 4.6f, 86, sample_product_id),
)