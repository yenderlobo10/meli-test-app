package com.test.meli.catalog.domain

interface CatalogRepository {

    suspend fun searchProducts(q:String): List<ProductItem>
}