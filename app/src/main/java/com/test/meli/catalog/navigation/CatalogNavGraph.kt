package com.test.meli.catalog.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import androidx.navigation.navigation
import com.test.meli.catalog.presentation.CatalogScreen
import com.test.meli.catalog.presentation.CatalogViewModel
import com.test.meli.core.navigation.AppRoutes
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.addCatalogNavGraph() {
    val defaultRoute = "${AppRoutes.Catalog.label}/{q}"

    navigation(
        startDestination = defaultRoute,
        route = AppRoutes.Catalog.label
    ) {

        composable(
            route = defaultRoute,
            arguments = listOf(
                navArgument("q") { type = NavType.StringType }
            )
        ) {

            val query = it.arguments?.getString("q")
            requireNotNull(query) { "@query argument must be not null." }

            CatalogScreen(
                query = query,
                catalogViewModel = koinViewModel<CatalogViewModel>()
            )
        }

        // Add other graph routes...
    }
}