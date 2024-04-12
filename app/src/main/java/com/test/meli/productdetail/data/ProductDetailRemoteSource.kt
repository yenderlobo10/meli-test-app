package com.test.meli.productdetail.data

import com.test.meli.core.data.api.meli.MeliCatalogService
import com.test.meli.core.data.api.meli.models.MeliProductItem
import com.test.meli.core.observability.AppLogger
import com.test.meli.productdetail.domain.ProductGetDetailError

interface ProductDetailRemoteSource {

    suspend fun getDetail(id: String): MeliProductItem?
}

class ProductDetailRemoteSourceImpl(
    private val meliCatalogService: MeliCatalogService
) : ProductDetailRemoteSource {

    override suspend fun getDetail(id: String): MeliProductItem? {
        val result = meliCatalogService.searchProducts(
            status = "active",
            siteId = "MCO",
            q = id,
            limit = 20
        )

        if (result.isSuccessful) {

            result.body()?.let { data ->
                data.results.takeIf { it.isNotEmpty() }?.let {
                    return it.first()
                }
            }

            return null
        }

        AppLogger.error(
            "Error get product detail -> Code:${result.code()} Detail: ${result.message()}"
        )
        throw ProductGetDetailError(
            code = result.code(),
            message = result.message()
        )
    }
}