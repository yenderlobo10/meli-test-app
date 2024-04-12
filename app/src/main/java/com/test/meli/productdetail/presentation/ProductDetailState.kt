package com.test.meli.productdetail.presentation

import com.test.meli.productdetail.domain.ProductDetail

data class ProductDetailState(
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val detail: ProductDetail? = null
)
