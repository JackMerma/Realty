package com.example.realty

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward // Ícono a la izquierda
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(onBackClick: () -> Unit) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val interactionSource = remember { MutableInteractionSource() }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerContent(onCloseDrawer = { scope.launch { drawerState.close() } })
        }
    ) {
        Scaffold(
            modifier = Modifier.fillMaxSize(),
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = "Perfil",
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxSize()
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = onBackClick) {
                            Icon(
                                imageVector = Icons.Default.ArrowBack,
                                contentDescription = "Back"
                            )
                        }
                    }
                )
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                ProfileInfo(
                    profileImage = R.drawable.ic_profile_image,
                    name = "Andrea Hirata",
                    email = "hirata@gmail.com"
                )
                Spacer(modifier = Modifier.height(24.dp))
                OptionsList(onEditProfileClick = { scope.launch { drawerState.open() } })
            }

            if (drawerState.isOpen) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Transparent)
                        .clickable(
                            interactionSource = interactionSource,
                            indication = null,
                            onClick = {
                                scope.launch { drawerState.close() }
                            }
                        )
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(250.dp)
                            .align(Alignment.CenterStart)
                    )
                }
            }
        }
    }
}

@Composable
fun DrawerContent(onCloseDrawer: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .width(250.dp)
            .background(Color(0xFFE0E0E0))
    ) {
        Column(modifier = Modifier
            .fillMaxHeight()
            .padding(16.dp)) {

            Spacer(modifier = Modifier.height(24.dp))

            val subOptions = listOf("Home", "Carrito", "Ajustes", "Ayuda", "Contactenos")
            val iconResources = listOf(
                R.drawable.ic_home,
                R.drawable.ic_cart,
                R.drawable.ic_settings,
                R.drawable.ic_help,
                R.drawable.ic_user
            )

            subOptions.forEachIndexed { index, subOption ->
                Row(
                    modifier = Modifier
                        .padding(vertical = 12.dp)
                        .fillMaxWidth()
                        .clickable { /* Acción de clic */ },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = iconResources[index]),
                        contentDescription = subOption,
                        modifier = Modifier.padding(end = 8.dp)
                    )
                    Text(
                        text = subOption,
                        fontSize = 16.sp
                    )
                }
                Divider(color = Color(0xFFCCCCCC), thickness = 1.dp)
            }
        }
    }
}

@Composable
fun OptionsList(onEditProfileClick: () -> Unit) {
    val options = mapOf(
        "General" to listOf("Edit Profile", "Notifications", "Wishlist"),
        "Legal" to listOf("Terms of Use", "Privacy Policy"),
        "Personal" to listOf("Report a Bug", "Logout")
    )

    Column(modifier = Modifier.fillMaxWidth()) {
        options.forEach { (category, items) ->
            Text(
                text = category,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            items.forEachIndexed { index, item ->
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                ) {
                    TextButton(
                        onClick = {
                            if (item == "Edit Profile") {
                                onEditProfileClick()
                            }
                        },
                        modifier = Modifier.weight(1f)
                    ) {
                        Text(text = item)
                    }
                }
                if (index < items.size - 1) {
                    Divider(color = Color(0xFFCCCCCC), thickness = 1.dp)
                }
            }
        }
    }
}

@Composable
fun ProfileInfo(name: String, email: String, profileImage: Int) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = profileImage),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(75.dp)
                .clip(CircleShape)
        )
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(start = 30.dp)
        ) {
            Text(
                text = name,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Text(
                text = email,
                color = Color.Gray,
                fontSize = 16.sp
            )
        }
    }
}
