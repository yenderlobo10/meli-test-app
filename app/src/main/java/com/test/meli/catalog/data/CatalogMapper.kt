package com.test.meli.catalog.data

import com.test.meli.catalog.domain.ProductItem
import com.test.meli.core.data.api.meli.models.MeliPicture
import com.test.meli.core.data.api.meli.models.MeliProductItem
import com.test.meli.core.utils.getRandomPrice

fun MeliProductItem.toProductItem() = ProductItem(
    id = this.id,
    name = this.name,
    imageUrl = this.pictures.takeFirstUrlOrBlank(),
    price = getRandomPrice()
)

fun List<MeliPicture>.takeFirstUrlOrBlank(): String {
    return this.takeIf { it.isNotEmpty() }?.first()?.url ?: ""
}