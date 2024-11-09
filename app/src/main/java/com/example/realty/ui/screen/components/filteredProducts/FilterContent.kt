package com.example.realty.ui.screen.components.filteredProducts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FilterContent(
    filterSettings: FilterSettings,
    onApplyClick: () -> Unit
) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Filtro", fontSize = 24.sp, fontWeight = FontWeight.Bold)

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Categoría")
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            val categories = listOf("Running", "Basquetbol", "Fútbol", "Casual")
            categories.forEach { category ->
                OutlinedButton(
                    onClick = { filterSettings.category = category },
                    colors = if (filterSettings.category == category) {
                        ButtonDefaults.outlinedButtonColors(contentColor = Color.White, containerColor = Color.Black)
                    } else {
                        ButtonDefaults.outlinedButtonColors(contentColor = Color.Black)
                    }
                ) {
                    Text(text = category)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Ordenar por")
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            val sortOptions = listOf("Popularidad", "Más nuevo", "Más antiguo", "Mayor precio", "Menor precio", "Reseñas")
            sortOptions.forEach { option ->
                OutlinedButton(
                    onClick = { filterSettings.orderBy = option },
                    colors = if (filterSettings.orderBy == option) {
                        ButtonDefaults.outlinedButtonColors(contentColor = Color.White, containerColor = Color.Black)
                    } else {
                        ButtonDefaults.outlinedButtonColors(contentColor = Color.Black)
                    }
                ) {
                    Text(text = option)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Rango de precios")
        Row {
            OutlinedButton(
                onClick = { /* TODO: Add price range logic */ },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = filterSettings.minPrice.ifEmpty { "Precio mínimo" })
            }
            Spacer(modifier = Modifier.width(8.dp))
            OutlinedButton(
                onClick = { /* TODO: Add price range logic */ },
                modifier = Modifier.weight(1f)
            ) {
                Text(text = filterSettings.maxPrice.ifEmpty { "Precio máximo" })
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedButton(
            onClick = onApplyClick,
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.Black, contentColor = Color.White)
        ) {
            Text(text = "Aplicar filtro")
        }
    }
}