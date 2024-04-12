package com.test.meli.productdetail.data

import com.test.meli.core.data.api.meli.models.MeliProductItem
import com.test.meli.core.utils.getRandomPrice
import com.test.meli.productdetail.domain.Attribute
import com.test.meli.productdetail.domain.ProductDetail

fun MeliProductItem.toProductDetail() = ProductDetail(
    id = this.id,
    name = this.name,
    price = getRandomPrice(),
    pictures = this.pictures.map { it.url },
    attributes = this.attributes.map {
        Attribute(
            label = it.name,
            value = it.valueName ?: ""
        )
    }
)