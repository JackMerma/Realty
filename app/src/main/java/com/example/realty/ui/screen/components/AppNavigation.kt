package com.example.realty.ui.screen.components

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "cart_screen") {
        composable("cart_screen") {
            CartScreen(navController = navController)
        }
        composable("payment_options_screen") {
            PaymentOptionsScreen(navController = navController)
        }
        composable("virtual_wallet_option_screen") {
            VirtualWalletOptionScreen()
        }
        composable("whatsapp_option_screen") {
            WhatAppOptionScreen()
        }
    }
}