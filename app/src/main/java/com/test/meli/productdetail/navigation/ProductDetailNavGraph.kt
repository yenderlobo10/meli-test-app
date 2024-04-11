package com.test.meli.productdetail.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.test.meli.core.navigation.AppNavRoute
import com.test.meli.productdetail.presentation.ProductDetailScreen

fun NavGraphBuilder.addProductDetailNavGraph() {
    navigation(
        startDestination = "/",
        route = AppNavRoute.ProductDetail.path
    ) {

        composable(route = "/") {
            ProductDetailScreen()
        }

        // Add other graph routes...
    }
}