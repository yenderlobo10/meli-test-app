package com.test.meli.productdetail.domain

data class ProductDetail(
    val id: String,
    val name: String,
    val price: Double,
    val pictures: List<String>,
    val attributes: List<Attribute>
)

data class Attribute(
    val label: String,
    val value: String
)
