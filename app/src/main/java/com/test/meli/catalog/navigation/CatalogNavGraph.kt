package com.test.meli.catalog.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.test.meli.catalog.presentation.CatalogScreen
import com.test.meli.common.navigation.AppNavRoute

fun NavGraphBuilder.addCatalogNavGraph() {
    navigation(
        startDestination = "/",
        route = AppNavRoute.Catalog.path
    ) {

        composable(route = "/") {
            CatalogScreen()
        }

        // Add other graph routes...
    }
}