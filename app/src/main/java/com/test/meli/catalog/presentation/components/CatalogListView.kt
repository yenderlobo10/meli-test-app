package com.test.meli.catalog.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.compose.AsyncImage
import com.test.meli.R
import com.test.meli.catalog.domain.ProductItem
import com.test.meli.catalog.presentation.CatalogContent
import com.test.meli.catalog.presentation.common.productItemPrev
import com.test.meli.catalog.presentation.common.productsPrev
import com.test.meli.core.extensions.capitalizeWords
import com.test.meli.core.extensions.toCurrencyFormat

@Composable
internal fun CatalogListView(
    items: List<ProductItem>
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item {
            Text(
                text = "${items.size} resultados",
                modifier = Modifier.padding(start = 16.dp, bottom = 16.dp)
            )
        }
        items(
            items,
            key = { it.id }
        ) {
            CatalogListItem(item = it)
        }
    }
}

@Composable
private fun CatalogListItem(
    item: ProductItem
) {
    ConstraintLayout(
        Modifier
            .fillMaxWidth()
            .clickable { /*TODO*/ }
    ) {
        val (image, title, price, buttonFavorite, divider) = createRefs()
        var imageScaling by remember { mutableStateOf(ContentScale.Inside) }

        AsyncImage(
            model = item.imageUrl,
            contentDescription = "",
            placeholder = painterResource(id = R.drawable.img_placeholder),
            error = painterResource(id = R.drawable.img_placeholder),
            contentScale = imageScaling,
            onError = {
                imageScaling = ContentScale.Crop
            },
            modifier = Modifier
                .size(86.dp)
                .clip(RoundedCornerShape(6.dp))
                .background(color = Color.White)
                .constrainAs(image) {
                    start.linkTo(parent.start, margin = 12.dp)
                    top.linkTo(parent.top)
                }
        )

        Text(
            modifier = Modifier.constrainAs(title) {
                start.linkTo(image.end, margin = 12.dp)
                top.linkTo(image.top)
                end.linkTo(buttonFavorite.start)
                width = Dimension.preferredWrapContent
            },
            text = item.name.capitalizeWords(),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.bodyLarge
        )

        Text(
            modifier = Modifier.constrainAs(price) {
                start.linkTo(title.start)
                top.linkTo(title.bottom, margin = 8.dp)
                width = Dimension.wrapContent
            },
            text = item.price.toCurrencyFormat(),
            maxLines = 1,
            style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Medium)
        )

        IconToggleButton(
            modifier = Modifier.constrainAs(buttonFavorite) {
                end.linkTo(parent.end, margin = 4.dp)
                top.linkTo(parent.top)
                bottom.linkTo(parent.bottom)
            },
            checked = false,
            onCheckedChange = {/*TODO*/ }) {
            Icon(
                imageVector = Icons.Outlined.FavoriteBorder,
                contentDescription = "icon-favorite"
            )
        }

        HorizontalDivider(
            Modifier.constrainAs(divider) {
                top.linkTo(image.bottom, margin = 4.dp)
                bottom.linkTo(parent.bottom)
            }
        )
    }
}

@Preview
@Composable
private fun CatalogContentPrev() {
    Surface {
        CatalogContent(
            products = productsPrev
        )
    }
}

@Preview
@Composable
private fun CatalogListItemPrev() {
    Surface {
        CatalogListItem(
            item = productItemPrev
        )
    }
}