package com.test.meli.productdetail.presentation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ProductDetailScreen() {
    Scaffold {
        Surface(Modifier.padding(it)) {
            Text(text = "Product detail screen")
        }
    }
}