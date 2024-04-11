package com.test.meli.catalog.data

import com.test.meli.catalog.domain.ProductItem
import com.test.meli.core.data.api.meli.models.MeliPicture
import com.test.meli.core.data.api.meli.models.MeliProductItem
import kotlin.random.Random

fun MeliProductItem.toProductItem() = ProductItem(
    id = this.id,
    name = this.name,
    imageUrl = this.pictures.takeFirstUrlOrBlank(),
    price = Random.nextDouble(from = 9999.9, until = 999999.9)
)

fun List<MeliPicture>.takeFirstUrlOrBlank(): String {
    return this.takeIf { it.isNotEmpty() }?.first()?.url ?: ""
}