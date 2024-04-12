package com.test.meli.productdetail.domain

interface ProductDetailRepository {

    suspend fun getDetail(id: String): ProductDetail?
}