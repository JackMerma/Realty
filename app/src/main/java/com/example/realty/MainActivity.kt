package com.example.realty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.realty.ui.theme.RealtyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RealtyTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    var showProfile by remember { mutableStateOf(false) }

    if (showProfile) {
        ProfileScreen(onBackClick = { showProfile = false })
    } else {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            Button(onClick = { showProfile = true }) {
                Text("Show Profile")
            }
        }
    }
}
