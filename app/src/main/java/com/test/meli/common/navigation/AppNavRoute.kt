package com.test.meli.common.navigation

sealed class AppNavRoute(
    val path: String
) {

    data object Search : AppNavRoute(path = "search")

    data object Catalog : AppNavRoute(path = "catalog")

    data object ProductDetail : AppNavRoute(path = "product-detail")
}