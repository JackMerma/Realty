package com.example.realty.data

// Main product class
data class Product(
    val name: String,
    val price: String,
    val rating: Float,
    val reviews: Int,
    val imageUrl: String
)

const val sample_product_url = "https://assets.adidas.com/images/h_840,f_auto,q_auto,fl_lossy,c_fill,g_auto/aa53a0a800c846abb44aae8a00367e1d_9366/Zapatillas_Tensaur_Sport_Training_Cierre_de_Cordones_Blanco_GW6422_01_standard.jpg"
// Defining sample products
val productList = listOf(
    Product("Tensaur Sport Training", "SOL 100", 4.6f, 86, sample_product_url),
    Product("Tensaur Sport Training", "SOL 100", 4.6f, 86, sample_product_url),
    Product("Tensaur Sport Training", "SOL 100", 4.6f, 86, sample_product_url),
    Product("Tensaur Sport Training", "SOL 100", 4.6f, 86, sample_product_url)
)