package com.example.realty.ui.screen.components

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.realty.data.Product
import com.example.realty.data.productList

@Composable
fun FilteredProducts(
    modifier: Modifier,
    query: String
){
    Column(modifier = modifier.padding(16.dp)) {
        Header()
        Spacer(modifier = Modifier.height(16.dp))
        FilterOptions()
        Spacer(modifier = Modifier.height(16.dp))
        ProductGrid(products = productList)
    }
}

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
        Text(text = "Popularity", modifier = Modifier.clickable {
            // TODO: ?
        })
        Text(text = "Newest", modifier = Modifier.clickable {
            // TODO: ?
        })
        Text(text = "Most Expensive", modifier = Modifier.clickable {
            // TODO: ?
        })
    }
}

@Composable
fun ProductGrid(products: List<Product>) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(products.size) { index ->
            ProductCard(product = products[index])
        }
    }
}

@Composable
fun ProductCard(product: Product) {
    Card(
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                // TODO: ?
            }
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(8.dp)
        ) {
            Image(
                painter = rememberImagePainter(product.imageUrl),
                contentDescription = product.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(120.dp)
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = product.name, fontWeight = FontWeight.Bold)
            Text(text = product.price, fontSize = 14.sp, color = Color.Black)
            Spacer(modifier = Modifier.height(4.dp))
            RatingBar(rating = product.rating, reviews = product.reviews)
        }
    }
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