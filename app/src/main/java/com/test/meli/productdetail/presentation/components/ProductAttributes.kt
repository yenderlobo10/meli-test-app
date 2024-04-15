package com.test.meli.productdetail.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.test.meli.R
import com.test.meli.core.extensions.capitalize
import com.test.meli.core.presentation.theme.AppTheme
import com.test.meli.productdetail.domain.Attribute
import com.test.meli.productdetail.presentation.common.attributesPrev

@Composable
fun ProductAttributes(
    modifier: Modifier = Modifier,
    attributes: List<Attribute>
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text(
            text = stringResource(R.string.detail_attributes_title),
            style = MaterialTheme.typography.titleSmall,
            modifier = Modifier.padding(vertical = 12.dp)
        )

        repeat(attributes.size) {
            ItemRow(item = attributes[it])
        }
    }
}

@Composable
private fun ItemRow(
    item: Attribute
) {
    OutlinedCard {
        Row(
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = item.label.capitalize(),
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 4.dp)
            )

            Text(
                text = item.value,
                modifier = Modifier.weight(1f),
                style = MaterialTheme.typography.labelLarge.copy(
                    fontWeight = FontWeight.Normal
                ),
            )
        }
    }
}

@Preview
@Composable
private fun ProductAttributesPrev() {
    AppTheme {
        Surface(Modifier.fillMaxWidth()) {
            ProductAttributes(
                attributes = attributesPrev
            )
        }
    }
}