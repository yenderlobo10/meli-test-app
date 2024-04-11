@file:OptIn(ExperimentalMaterial3Api::class)

package com.test.meli.catalog.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
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
import com.test.meli.catalog.presentation.components.CatalogErrorContent
import com.test.meli.catalog.presentation.components.CatalogListView
import com.test.meli.catalog.presentation.components.CatalogLoadingContent
import com.test.meli.core.extensions.capitalize
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
        products = catalogState.products
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
private fun CatalogScaffold(
    query: String,
    isLoading: Boolean,
    isError: Boolean,
    products: List<ProductItem>
) {
    val scrollBehavior =
        TopAppBarDefaults.exitUntilCollapsedScrollBehavior(rememberTopAppBarState())

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            TopBar(
                query = query,
                visible = true,
                scrollBehavior = scrollBehavior
            )
        }
    ) { innerPadding ->
        Surface(Modifier.padding(innerPadding)) {
            when {
                isLoading -> CatalogLoadingContent()
                isError -> CatalogErrorContent(message = "Error!")
                else -> CatalogContent(
                    products = products
                )
            }
        }
    }
}

@Composable
private fun TopBar(
    query: String,
    visible: Boolean,
    scrollBehavior: TopAppBarScrollBehavior
) {
    if (visible)
        MediumTopAppBar(
            navigationIcon = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Rounded.ArrowBack,
                        contentDescription = "nav-back-icon"
                    )
                }
            },
            title = ColumnScope@{
                Text(text = query.capitalize())
            },
            actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_grid_view),
                        contentDescription = "view-mode-icon"
                    )
                }
            },
            scrollBehavior = scrollBehavior
        )
}

@Composable
fun CatalogContent(
    products: List<ProductItem>
) {
    CatalogListView(
        items = products
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
            products = productsPrev
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

