package com.test.meli.catalog.domain

class CatalogSearchError(
    val code: Int,
    override val message: String?,
    override val cause: Throwable? = null
) : Exception()