package com.example.realty.ui.screen.components.filteredProducts

import com.example.realty.data.Product
import com.example.realty.data.productList
import kotlin.math.min

const val MAX_AMOUNT = 10

fun Search(
    query: String
): List<Product> {
    val matchList = productList.sortedBy { levenshtein(query, it.name) }
    return matchList.subList(0, min(matchList.size, MAX_AMOUNT))
}

fun levenshtein(a: String, b: String): Int {
    val costs = IntArray(b.length + 1) { it }
    for (i in 1..a.length) {
        var lastValue = i - 1
        costs[0] = i
        for (j in 1..b.length) {
            val newValue = minOf(
                costs[j] + 1,
                costs[j - 1] + 1,
                lastValue + if (a[i - 1] == b[j - 1]) 0 else 1
            )
            lastValue = costs[j]
            costs[j] = newValue
        }
    }
    return costs[b.length]
}