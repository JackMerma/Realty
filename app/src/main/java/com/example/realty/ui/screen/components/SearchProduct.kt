package com.example.realty.ui.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.realty.R

@Composable
fun SearchProduct(
    modifier: Modifier,
) {
    val lastSearches = listOf("TMA2 Wireless", "Cable")
    val popularProducts = listOf(
        Product("Tensaur Sport Training", "SOL 100", 4.6f, 86),
        Product("TMA-2 DJ", "SOL 100", 4.6f, 86),
        Product("TMA-2 Move Wireless", "SOL 100", 4.6f, 86)
    )

    Column(modifier = modifier.padding(16.dp)) {
        SearchBar()
        Spacer(modifier = Modifier.height(16.dp))
        LastSearchesSection(lastSearches)
        Spacer(modifier = Modifier.height(16.dp))
        PopularProductsSection(popularProducts)
    }
}

@Composable
fun LastSearchesSection(lastSearches: List<String>) {
    Column {
        Text(text = "Última búsqueda", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(8.dp))
        lastSearches.forEach { search ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                    }
                    .padding(vertical = 8.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(
                    modifier = Modifier.size(16.dp),
                    painter = painterResource(id = R.drawable.clock),
                    contentDescription = "Recent Search",
                    tint = Color(0xffbababa),
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = search, style = MaterialTheme.typography.bodyMedium)
                Spacer(modifier = Modifier.weight(1f))
                Icon(
                    modifier = Modifier
                        .size(10.dp)
                        .clickable {
                        },
                    painter = painterResource(id = R.drawable.close),
                    contentDescription = "Remove Search",
                )
            }
        }
    }
}

@Composable
fun PopularProductsSection(products: List<Product>) {
    Column {
        Text(text = "Productos populares", style = MaterialTheme.typography.bodyLarge)
        Spacer(modifier = Modifier.height(8.dp))
        products.forEach { product ->
            ProductItem(product)
        }
    }
}

@Composable
fun ProductItem(product: Product) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
            }
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.shoes),
            contentDescription = product.name,
            modifier = Modifier.width(100.dp).height(100.dp).background(color = Color(0xfff6f6f6), shape = RoundedCornerShape(15))
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(text = product.name, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = product.price, style = MaterialTheme.typography.titleSmall, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(12.dp))
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = "Rating",
                    tint = Color(0xff0acf83),
                    modifier = Modifier.size(16.dp)
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(text = "${product.rating}", style = MaterialTheme.typography.bodySmall)
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = " ${product.reviews} Reseñas", style = MaterialTheme.typography.bodySmall)
            }
        }
        Icon(
            modifier = Modifier.size(16.dp),
            painter = painterResource(id = R.drawable.more),
            contentDescription = "More options",
            tint = Color(0xff7f7f7f),
        )
    }
}

// Model data class
data class Product(
    val name: String,
    val price: String,
    val rating: Float,
    val reviews: Int
)