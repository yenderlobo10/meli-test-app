package com.test.meli.core.data.api.meli

import com.test.meli.core.data.api.meli.models.MeliCatalogResult
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MeliCatalogService {

    @GET("products/search")
    suspend fun searchProducts(
        @Query("status") status: String,
        @Query("site_id") siteId: String,
        @Query("q") q: String,
        @Query("limit") limit: Int
    ): Response<MeliCatalogResult>
}