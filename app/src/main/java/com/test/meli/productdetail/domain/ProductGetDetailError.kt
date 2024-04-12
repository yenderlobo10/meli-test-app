package com.test.meli.productdetail.domain

class ProductGetDetailError(
    val code: Int,
    override val message: String?,
    override val cause: Throwable? = null
) : Exception()