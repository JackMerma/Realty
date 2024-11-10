package com.example.realty.ui.screen.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.realty.data.Product
import com.example.realty.R
import com.example.realty.data.CartItem

@Composable
fun CartScreen() {
    val cartItems = remember {
        mutableStateListOf(
            CartItem(Product("Tensaur Sport Training", 100f, 4.6f, 86, R.drawable.shoes), 1),
            CartItem(Product("Tensaur Training", 100f, 4.6f, 86, R.drawable.shoes), 1)
        )
    }

    val totalPrice = cartItems.sumOf { (it.product.price * it.quantity).toDouble() }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.padding(16.dp).fillMaxSize()) {
            Text("Carrito de Compras", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(cartItems) { cartItem ->
                    ProductCardItem(
                        cartItem = cartItem,
                        onQuantityChange = { newQuantity ->
                            val index = cartItems.indexOf(cartItem)
                            if (index != -1) {
                                cartItems[index] = cartItem.copy(quantity = newQuantity)
                            }
                        }
                    )
                    Spacer(modifier = Modifier.height(16.dp)) // Add space between items
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Total", fontWeight = FontWeight.Bold)
                Text(
                    "SOL ${"%.2f".format(totalPrice)}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }

            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
            ) {
                Text(
                    text = "Continuar",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }
        }
    }
}

@Composable
fun ProductCardItem(cartItem: CartItem, onQuantityChange: (Int) -> Unit) {
    val product = cartItem.product
    Card(
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { }
            .padding(horizontal = 16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = product.imageId),
                contentDescription = product.name,
                modifier = Modifier
                    .size(100.dp)
                    .padding(end = 16.dp)
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f)
            ) {
                Text(text = product.name, fontWeight = FontWeight.Bold)
                Text(text = "SOL ${product.price}", fontSize = 14.sp, color = Color.Black, fontWeight = FontWeight.Bold)

                Spacer(modifier = Modifier.height(8.dp))

                ModifyQuantity(
                    quantity = cartItem.quantity,
                    onQuantityChange = onQuantityChange
                )
            }
        }
    }
}

@Composable
fun ModifyQuantity(quantity: Int, onQuantityChange: (Int) -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        IconButton(onClick = { if (quantity > 1) onQuantityChange(quantity - 1) }) {
            Icon(imageVector = Icons.Default.Clear, contentDescription = "Decrease Quantity")
        }

        Text(
            text = quantity.toString(),
            modifier = Modifier.padding(horizontal = 16.dp)
        )

        IconButton(onClick = { onQuantityChange(quantity + 1) }) {
            Icon(imageVector = Icons.Default.Add, contentDescription = "Increase Quantity")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCartScreen() {
    val cartItems = remember {
        mutableStateListOf(
            CartItem(Product("Tensaur Sport Training", 100f, 4.6f, 86, R.drawable.shoes), 1),
            CartItem(Product("Tensaur Training", 100f, 4.6f, 86, R.drawable.shoes), 1)
        )
    }

    val totalPrice = cartItems.sumOf { (it.product.price * it.quantity).toDouble() }

    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.padding(16.dp).fillMaxSize()) {
            Text("Carrito de Compras", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(16.dp))

            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                items(cartItems) { cartItem ->
                    ProductCardItem(
                        cartItem = cartItem,
                        onQuantityChange = { newQuantity ->
                            val index = cartItems.indexOf(cartItem)
                            if (index != -1) {
                                cartItems[index] = cartItem.copy(quantity = newQuantity)
                            }
                        }
                    )
                    Spacer(modifier = Modifier.height(16.dp)) // Add space between items
                }
            }

            Spacer(modifier = Modifier.height(16.dp))
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Total", fontWeight = FontWeight.Bold)
                Text(
                    "SOL ${"%.2f".format(totalPrice)}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }

            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
            ) {
                Text(
                    text = "Continuar",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
            }
        }
    }
}