package com.example.realty.ui.screen.components.filteredProducts

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
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
import com.example.realty.R

@Composable
fun FilteredProducts(
    modifier: Modifier,
    query: String
){

    // Getting the related list based in the query
    val relatedList = Search(query)

    Column(modifier = modifier.padding(16.dp)) {
        Header()
        Spacer(modifier = Modifier.height(16.dp))
        FilterOptions()
        Spacer(modifier = Modifier.height(16.dp))
        Card(
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = Color(0xfff3f3f3))
        ){
            ProductGrid(products = relatedList)
        }
    }
}

@Composable
fun Header() {
    Column {
        Text(text = "TMA Wireless", fontSize = 24.sp, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun FilterOptions() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedButton(
            onClick = {},
            shape = RoundedCornerShape(25),
            border = BorderStroke(1.dp, Color.LightGray),
            colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.Black)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.filter),
                contentDescription = "Filter",
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(5.dp))
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
        contentPadding = PaddingValues(17.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(products.size) { index ->
            ProductCard(product = products[index])
        }
    }
}

@Composable
fun ProductCard(product: Product) {
    Card(
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable {
                // TODO: ?
            },
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = product.imageId),
                contentDescription = product.name,
                modifier = Modifier
                    .size(150.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = product.name)
            Text(text = product.price, fontSize = 14.sp, color = Color.Black, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(4.dp))
            RatingBar(rating = product.rating, reviews = product.reviews)
        }
    }
}

@Composable
fun RatingBar(rating: Float, reviews: Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.star),
            contentDescription = "Rating",
            tint = Color(0xff0acf83),
            modifier = Modifier.size(16.dp)
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = "$rating", fontSize = 14.sp)
        Spacer(modifier = Modifier.width(4.dp))
        Text(text = "($reviews Reviews)", fontSize = 12.sp, color = Color.Gray)
    }
}