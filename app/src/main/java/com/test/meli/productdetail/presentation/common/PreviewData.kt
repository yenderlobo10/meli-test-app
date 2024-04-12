package com.test.meli.productdetail.presentation.common

import com.test.meli.core.utils.getGuid
import com.test.meli.productdetail.domain.Attribute
import com.test.meli.productdetail.domain.ProductDetail

val urlOfPicturesPrev = (1..5).map { getGuid() }

val attributesPrev = (1..5).mapIndexed { i, _ ->
    Attribute(
        label = "label $i",
        value = "value $i"
    )
}

val productDetailPrev = ProductDetail(
    id = "MCO123456",
    name = "nombre de producto y algunas caracteristicas",
    price = 999999.9,
    pictures = urlOfPicturesPrev,
    attributes = attributesPrev
)
