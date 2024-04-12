package com.test.meli.core.navigation

sealed class AppNavRoute(
    val path: String
) {

    data object Search : AppNavRoute(
        path = AppRoutes.Search.label
    )

    data class Catalog(val query: String) : AppNavRoute(
        path = "${AppRoutes.Catalog.label}/$query"
    )

    data class ProductDetail(val id: String) : AppNavRoute(
        path = "${AppRoutes.ProductDetail.label}/$id"
    )
}

enum class AppRoutes(val label: String) {
    Search(label = "search"),
    Catalog(label = "catalog"),
    ProductDetail(label = "detail")
}