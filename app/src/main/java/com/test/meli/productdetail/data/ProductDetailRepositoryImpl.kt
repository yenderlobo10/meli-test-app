package com.test.meli.productdetail.data

import com.test.meli.productdetail.domain.ProductDetail
import com.test.meli.productdetail.domain.ProductDetailRepository

class ProductDetailRepositoryImpl(
    private val remoteSource: ProductDetailRemoteSource
) : ProductDetailRepository {

    override suspend fun getDetail(id: String): ProductDetail? {
        val result = remoteSource.getDetail(id)

        return result?.toProductDetail()
    }
}