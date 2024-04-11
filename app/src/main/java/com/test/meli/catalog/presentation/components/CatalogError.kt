package com.test.meli.catalog.presentation.components

import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
internal fun CatalogErrorContent(
    message: String
) {
    Text(text = message)
}

@Preview
@Composable
private fun CatalogErrorContentPrev() {
    Surface {
        CatalogErrorContent(
            message = "Error!"
        )
    }
}