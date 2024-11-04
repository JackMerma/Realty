package com.example.realty.ui.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.realty.R

@Composable
fun Home(
    modifier: Modifier,
) {
    var user_name = "Eduardo";

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        GreetingSection(user_name)
        Spacer(modifier = Modifier.height(30.dp))
        SearchBar()
        Spacer(modifier = Modifier.height(30.dp))

        Card(
            colors = CardDefaults.cardColors(containerColor = Color(0xfff6f6f6)),
            shape = RoundedCornerShape(25.dp),
        ){
            Row(
                modifier = Modifier.padding(20.dp)
            ){
                Column {
                    CategorySection()
                    Spacer(modifier = Modifier.height(16.dp))
                    ProductHighlightSection()
                    Spacer(modifier = Modifier.height(16.dp))
                    BestProductsSection()
                }
            }
        }
    }
}

@Composable
fun GreetingSection(
    user_name: String
) {
    Text(
        text = "Hola, $user_name",
        style = TextStyle(fontSize = 17.sp)
    )
    Spacer(modifier = Modifier.height(5.dp))
    Text(
        text = "¿Qué estas buscando hoy?",
        style = TextStyle(fontSize = 27.sp, fontWeight = FontWeight.Bold)
    )
}

@Composable
fun CategorySection() {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceAround
    ) {
        listOf("Running", "Basquetbol", "Fútbol", "Casual").forEach { category ->
            Text(
                text = category,
                modifier = Modifier
                    .background(
                        if (category == "Running") Color.Black else Color.Transparent,
                        shape = RoundedCornerShape(50)
                    )
                    .padding(15.dp, 4.dp)
                    .clickable {
                    },
                style = TextStyle(
                    color = if (category == "Running") Color.White else Color.Gray,
                ),
            )
        }
    }
}

@Composable
fun ProductHighlightSection() {
    Card(
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = Color.White),
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Column (
                modifier = Modifier.width(180.dp)
            ){
                Text(
                    text = "Tensaur Sport Training",
                    fontSize = 36.sp,
                    lineHeight = 40.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row (
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text("Compra ahora", fontWeight = FontWeight.Bold)
                    Spacer(modifier = Modifier.width(15.dp))
                    Icon(
                        painter = painterResource(id = R.drawable.next),
                        contentDescription = "Rating",
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
            Image(
                painter = painterResource(id = R.drawable.shoes),
                contentDescription = "Product Image",
                modifier = Modifier.size(200.dp, 150.dp)
            )
        }
    }
}

@Composable
fun BestProductsSection() {
    Column(modifier = Modifier.fillMaxWidth()) {
        Spacer(modifier = Modifier.height(7.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("Mejores productos", fontSize = 18.sp)
            Text("Ver Todos", color = Color.Gray)
        }
        Spacer(modifier = Modifier.height(25.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            ProductCard("Tensaur Sport Training", "SOL 100")
            ProductCard("CO2 - Cable", "USD 25")
            ProductCard("CO2 - Cable", "USD 25")
            ProductCard("CO2 - Cable", "USD 25")
            ProductCard("CO2 - Cable", "USD 25")
        }
    }
}

@Composable
fun ProductCard(name: String, price: String) {
    Card(
        shape = RoundedCornerShape(15.dp),
        modifier = Modifier.size(170.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.shoes),
                contentDescription = "Product Image",
                modifier = Modifier.size(130.dp, 80.dp)
            )
            Text(name, fontSize = 16.sp)
            Text(price, fontWeight = FontWeight.Bold)
        }
    }
}