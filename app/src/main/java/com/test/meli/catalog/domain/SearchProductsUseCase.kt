package com.test.meli.catalog.domain

class SearchProductsUseCase(
    private val catalogRepository: CatalogRepository
) {

    suspend operator fun invoke(q: String): List<ProductItem> {
        return catalogRepository.searchProducts(q)
    }
}