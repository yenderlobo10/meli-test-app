package com.test.meli.catalog.presentation

import com.test.meli.catalog.domain.ProductItem

data class CatalogState(
    val isLoading: Boolean = true,
    val products: List<ProductItem> = emptyList(),
    val isError: Boolean = false,
)