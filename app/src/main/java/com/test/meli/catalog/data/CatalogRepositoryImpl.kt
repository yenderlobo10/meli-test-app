package com.test.meli.catalog.data

import com.test.meli.catalog.domain.CatalogRepository
import com.test.meli.catalog.domain.ProductItem

class CatalogRepositoryImpl(
    private val remoteSource: CatalogRemoteSource
) : CatalogRepository {

    override suspend fun searchProducts(q: String): List<ProductItem> {
        val catalog = remoteSource.searchProducts(q = q)

        return catalog.results.map {
            it.toProductItem()
        }
    }
}