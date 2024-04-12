package com.test.meli.core.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
internal fun ErrorView(
    modifier: Modifier = Modifier,
    message: String
) {
    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Icon(
            imageVector = Icons.Rounded.Warning,
            contentDescription = "icon-warning",
            modifier = Modifier.size(48.dp)
        )
        Text(
            text = message,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(top = 12.dp)
        )
    }
}

@Preview
@Composable
private fun ErrorViewComponentPrev() {
    Surface {
        ErrorView(
            message = "Error!"
        )
    }
}