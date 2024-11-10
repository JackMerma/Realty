package com.example.realty.ui.screen.components.filteredProducts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalLayoutApi::class)
@Composable
fun FilterContent(
    filterSettings: FilterSettings,
    onApplyClick: () -> Unit
) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(text = "Filtro", fontSize = 24.sp, fontWeight = FontWeight.ExtraBold)

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Categoría")
        Spacer(modifier = Modifier.height(8.dp))
        FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            val categories = listOf("Category 1", "Category 2", "Category 3", "Category 4")
            categories.forEach { category ->
                Button(
                    onClick = { filterSettings.category.value = category },
                    colors = if (filterSettings.category.value == category) {
                        ButtonDefaults.outlinedButtonColors(contentColor = Color.White, containerColor = Color.Black)
                    } else {
                        ButtonDefaults.outlinedButtonColors(contentColor = Color.Black)
                    },
                ) {
                    Text(text = category)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Ordenar por")
        FlowRow(horizontalArrangement = Arrangement.spacedBy(4.dp)) {
            val sortOptions = listOf("Popularidad", "Más nuevo", "Más antiguo", "Mayor precio", "Menor precio", "Reseñas")
            sortOptions.forEach { option ->
                OutlinedButton(
                    onClick = { filterSettings.orderBy.value = option },
                    colors = if (filterSettings.orderBy.value == option) {
                        ButtonDefaults.outlinedButtonColors(contentColor = Color.White, containerColor = Color.Black)
                    } else {
                        ButtonDefaults.outlinedButtonColors(contentColor = Color(0xff7f7f7f))
                    },
                    shape = RoundedCornerShape(25)
                ) {
                    Text(text = option)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Rango de precios")
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            OutlinedButton(
                onClick = { /* TODO: Add price range logic */ },
                modifier = Modifier
                    .weight(1f)
                    .height(40.dp),
                shape = RoundedCornerShape(25),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xff7f7f7f))
            ) {
                //Text(text = filterSettings.minPrice.ifEmpty { "Precio mínimo" })
                Text(text = filterSettings.minPrice.value.toString())
            }
            Spacer(modifier = Modifier.width(8.dp))
            OutlinedButton(
                onClick = { /* TODO: Add price range logic */ },
                modifier = Modifier
                    .weight(1f)
                    .height(40.dp),
                shape = RoundedCornerShape(25),
                colors = ButtonDefaults.outlinedButtonColors(contentColor = Color(0xff7f7f7f))
            ) {
                Text(text = filterSettings.maxPrice.value.toString())
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        OutlinedButton(
            onClick = onApplyClick,
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.Black, contentColor = Color.White),
            shape = RoundedCornerShape(25)
        ) {
            Text(text = "Aplicar filtro", fontWeight = FontWeight.Bold, fontSize = 17.sp)
        }
    }
}