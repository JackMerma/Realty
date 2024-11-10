package com.example.realty.ui.screen.components

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.example.realty.R

@Composable
fun WhatAppOptionScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.padding(16.dp).fillMaxSize()) {
            Text("Carrito de Compras", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(16.dp))

            WhatsAppCardOption("Axel", "51951137753")
            Spacer(modifier = Modifier.height(16.dp))

            WhatsAppCardOption("Jackson", "51913068513")
            Spacer(modifier = Modifier.height(16.dp))

            WhatsAppCardOption("Barbara", "51901229773")
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun WhatsAppCardOption(name: String, phoneNumber: String) {
    val context = LocalContext.current

    Card(
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .fillMaxWidth()
            .clickable { openWhatsAppChat(context, name, phoneNumber) } // Llamamos a la función openWhatsAppChat
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
                painter = painterResource(id = R.drawable.whatsapp_payment),
                contentDescription = "",
                modifier = Modifier
                    .size(100.dp)
                    .padding(end = 16.dp)
            )

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1f)
            ) {
                Text(text = "Chatea con $name", fontWeight = FontWeight.Bold)
            }
        }
    }
}

fun openWhatsAppChat(context: Context, name: String, phoneNumber: String) {
    val message = "Hola $name! Quiero realizar el pago de mi compra, realizada por el aplicativo de Rea Kick."
    val url = "https://wa.me/$phoneNumber?text=${Uri.encode(message)}"

    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
    try {
        ContextCompat.startActivity(context, intent, null) // Usamos startActivity de manera segura
    } catch (e: ActivityNotFoundException) {
        Toast.makeText(context, "WhatsApp no está instalado", Toast.LENGTH_SHORT).show()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewYapeOptionScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column(modifier = Modifier.padding(16.dp).fillMaxSize()) {
            Text("Carrito de Compras", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(16.dp))

            WhatsAppCardOption("Axel", "51951137753")
            Spacer(modifier = Modifier.height(16.dp))

            WhatsAppCardOption("Jackson", "51913068513")
            Spacer(modifier = Modifier.height(16.dp))

            WhatsAppCardOption("Barbara", "51901229773")
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}