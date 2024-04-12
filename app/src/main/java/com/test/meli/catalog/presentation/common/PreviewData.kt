package com.test.meli.catalog.presentation.common

import com.test.meli.catalog.domain.ProductItem
import com.test.meli.core.utils.getGuid

internal val productItemPrev = ProductItem(
    id = "MCO123456",
    name = "name of product and resume features",
    imageUrl = "",
    price = 999999.9
)

internal val productsPrev = (1..10).map {
    productItemPrev.copy(
        id = getGuid()
    )
}