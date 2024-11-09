package com.example.realty.data
import com.example.realty.R

// Main product class
data class Product(
    val name: String,
    val price: String,
    val rating: Float,
    val reviews: Int,
    val imageId: Int
)

val sample_product_id = R.drawable.shoes

// Defining sample products
val productList = listOf(
    Product("Nike Air Force 1", "SOL 100", 4.6f, 86, sample_product_id),
    Product("Nike Dunk", "SOL 100", 4.6f, 86, sample_product_id),
    Product("New Balance 327", "SOL 100", 4.6f, 86, sample_product_id),
    Product("Chuck Taylor All Star", "SOL 100", 4.6f, 86, sample_product_id),
    Product("Nike Air Max", "SOL 100", 4.6f, 86, sample_product_id),
    Product("adidas NMD", "SOL 100", 4.6f, 86, sample_product_id),
    Product("Jordan I High OG", "SOL 100", 4.6f, 86, sample_product_id),
)