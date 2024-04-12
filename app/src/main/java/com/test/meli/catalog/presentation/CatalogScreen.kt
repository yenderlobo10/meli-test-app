@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.test.meli.catalog.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.test.meli.R
import com.test.meli.catalog.domain.ProductItem
import com.test.meli.catalog.presentation.common.productsPrev
import com.test.meli.catalog.presentation.components.ListView
import com.test.meli.core.extensions.capitalize
import com.test.meli.core.presentation.components.AppTopBarScaffold
import com.test.meli.core.presentation.components.ErrorView
import com.test.meli.core.presentation.components.LoadingView
import com.test.meli.core.presentation.theme.AppTheme

@Composable
fun CatalogScreen(
    query: String,
    catalogViewModel: CatalogViewModel
) {
    val catalogState by catalogViewModel.catalogState.collectAsState()

    CatalogScaffold(
        query = query,
        isLoading = catalogState.isLoading,
        isError = catalogState.isError,
        products = catalogState.products,
        onProductItemClick = {
            catalogViewModel.navigateToProductDetail(it)
        }
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
private fun CatalogScaffold(
    query: String,
    isLoading: Boolean,
    isError: Boolean,
    products: List<ProductItem>,
    onProductItemClick: (item: ProductItem) -> Unit
) {
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior(
        rememberTopAppBarState()
    )

    AppTopBarScaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        title = query.capitalize(),
        onNavigationIconClick = { /*TODO*/ },
        scrollBehavior = scrollBehavior,
        actions = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_grid_view),
                    contentDescription = "view-mode-icon"
                )
            }
        }
    ) { innerPadding ->
        Surface(Modifier.padding(innerPadding)) {
            when {
                isLoading -> LoadingView()

                isError -> ErrorView(message = "Error!")

                else -> CatalogView(
                    products = products,
                    onItemClick = onProductItemClick
                )
            }
        }
    }
}


@Composable
fun CatalogView(
    products: List<ProductItem>,
    onItemClick: (item: ProductItem) -> Unit
) {
    ListView(
        items = products,
        onItemClick = onItemClick
    )
}


@Preview
@Composable
private fun CatalogScaffoldPrev() {
    AppTheme {
        CatalogScaffold(
            query = "query input search",
            isLoading = true,
            isError = true,
            products = productsPrev,
            onProductItemClick = {}
        )
    }
}

@Preview
@Composable
private fun CatalogContentPrev() {
    Surface {
        CatalogView(
            products = productsPrev,
            onItemClick = {}
        )
    }
}

