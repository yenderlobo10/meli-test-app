@file:OptIn(ExperimentalMaterial3Api::class)

package com.test.meli.productdetail.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.test.meli.core.extensions.capitalizeWords
import com.test.meli.core.extensions.toCurrencyFormat
import com.test.meli.core.presentation.components.AppTopBarScaffold
import com.test.meli.core.presentation.components.ErrorView
import com.test.meli.core.presentation.components.LoadingView
import com.test.meli.core.presentation.theme.AppTheme
import com.test.meli.productdetail.domain.ProductDetail
import com.test.meli.productdetail.presentation.common.productDetailPrev
import com.test.meli.productdetail.presentation.components.PicturesCarrousel
import com.test.meli.productdetail.presentation.components.ProductAttributes

@Composable
fun ProductDetailScreen(
    id: String,
    productDetailViewModel: ProductDetailViewModel
) {
    val detailState by productDetailViewModel.detailState.collectAsState()

    ProductDetailScaffold(
        isLoading = detailState.isLoading,
        isError = detailState.isError,
        productDetail = detailState.detail
    )
}

@Composable
fun ProductDetailScaffold(
    isLoading: Boolean,
    isError: Boolean,
    productDetail: ProductDetail?
) {
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(
        rememberTopAppBarState()
    )

    AppTopBarScaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        title = "",
        onNavigationIconClick = { /*TODO*/ },
        scrollBehavior = scrollBehavior,
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Rounded.FavoriteBorder,
                    contentDescription = "view-mode-icon"
                )
            }
        }
    ) { innerPadding ->
        when {
            isLoading -> LoadingView()

            isError.or(productDetail == null) -> ErrorView(
                message = "Error product detail"
            )

            else -> ProductDetailView(
                innerPadding = innerPadding,
                productDetail = productDetail!!
            )
        }
    }
}

@Composable
private fun ProductDetailView(
    innerPadding: PaddingValues,
    productDetail: ProductDetail
) {
    Column(
        Modifier
            .padding(innerPadding)
            .padding(horizontal = 16.dp)
            .verticalScroll(rememberScrollState())

    ) {
        Text(
            text = productDetail.name.capitalizeWords(),
            style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Normal),
            maxLines = 2,
            overflow = TextOverflow.Ellipsis
        )

        Text(
            text = productDetail.price.toCurrencyFormat(),
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.SemiBold),
            modifier = Modifier.padding(vertical = 12.dp)
        )

        PicturesCarrousel(
            urlOfPictures = productDetail.pictures,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        ProductAttributes(
            attributes = productDetail.attributes,
            modifier = Modifier.padding(bottom = 24.dp)
        )
    }
}

@Preview
@Composable
private fun ProductDetailScaffoldPrev() {
    AppTheme {
        ProductDetailScaffold(
            productDetail = productDetailPrev,
            isLoading = false,
            isError = false,
        )
    }
}