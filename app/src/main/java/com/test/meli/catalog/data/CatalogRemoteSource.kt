package com.test.meli.catalog.data

import com.test.meli.catalog.domain.CatalogSearchError
import com.test.meli.core.data.api.meli.MeliCatalogService
import com.test.meli.core.data.api.meli.models.MeliCatalogResult
import com.test.meli.core.observability.AppLogger

interface CatalogRemoteSource {

    suspend fun searchProducts(q: String): MeliCatalogResult
}

class CatalogRemoteSourceImpl(
    private val meliCatalogService: MeliCatalogService
) : CatalogRemoteSource {

    override suspend fun searchProducts(q: String): MeliCatalogResult {
        val result = meliCatalogService.searchProducts(
            status = "active",
            siteId = "MCO",
            q = q,
            limit = 20
        )

        if (result.isSuccessful) {
            result.body()?.let {
                return it
            }
        }

        AppLogger.error(
            "Error searchProducts -> Code:${result.code()} Detail: ${result.message()}"
        )
        throw CatalogSearchError(
            code = result.code(),
            message = result.message()
        )
    }
}