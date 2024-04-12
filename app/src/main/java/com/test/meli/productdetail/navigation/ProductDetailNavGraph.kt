package com.test.meli.productdetail.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.test.meli.core.navigation.AppRoutes
import com.test.meli.productdetail.presentation.ProductDetailScreen
import com.test.meli.productdetail.presentation.ProductDetailViewModel
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.addProductDetailNavGraph() {
    val defaultRoute = "${AppRoutes.ProductDetail.label}/{id}"

    navigation(
        startDestination = defaultRoute,
        route = AppRoutes.ProductDetail.label
    ) {

        composable(
            route = defaultRoute,
            arguments = listOf(
                navArgument("id") { type = NavType.StringType }
            )
        ) {
            val id = it.arguments?.getString("id")
            requireNotNull(id) { "@id argument must be not null." }

            ProductDetailScreen(
                id = id,
                productDetailViewModel = koinViewModel<ProductDetailViewModel>()
            )
        }

        // Add other graph routes...
    }
}