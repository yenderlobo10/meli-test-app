package com.test.meli.search.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.test.meli.core.navigation.AppNavRoute
import com.test.meli.search.presentation.SearchScreen
import com.test.meli.search.presentation.SearchViewModel
import org.koin.androidx.compose.koinViewModel

fun NavGraphBuilder.addSearchNavGraph() {
    navigation(
        startDestination = "/",
        route = AppNavRoute.Search.path
    ) {

        composable(route = "/") {
            SearchScreen(
                searchViewModel = koinViewModel<SearchViewModel>()
            )
        }

        // Add other graph routes...
    }
}