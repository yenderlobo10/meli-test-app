package com.test.meli.core.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.test.meli.catalog.navigation.addCatalogNavGraph
import com.test.meli.productdetail.navigation.addProductDetailNavGraph
import com.test.meli.search.navigation.addSearchNavGraph
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@Composable
fun AppNavigationHost(
    navController: NavHostController,
    navigator: AppNavigator
) {
    val launchEffectNavigationKey = "navigation"

    LaunchedEffect(launchEffectNavigationKey) {
        navigator.sharedFlow.onEach {

            navController.navigate(it.path) {
                popUpTo(it.path)
            }

        }.launchIn(this)
    }

    NavHost(
        navController = navController,
        startDestination = AppNavRoute.Search.path
    ) {
        addSearchNavGraph()
        addCatalogNavGraph { navController.popBackStack() }
        addProductDetailNavGraph { navController.popBackStack() }
    }
}