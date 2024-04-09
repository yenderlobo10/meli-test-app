package com.test.meli.search.presentation

import androidx.lifecycle.ViewModel
import com.test.meli.common.navigation.AppNavRoute
import com.test.meli.common.navigation.AppNavigator
import com.test.meli.common.observability.AppLogger
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SearchViewModel(
    private val navigator: AppNavigator
) : ViewModel() {

    private val _searchState = MutableStateFlow(SearchState())
    val searchState: StateFlow<SearchState> = _searchState.asStateFlow()

    fun updateQuery(value: String) {
        _searchState.update {
            it.copy(query = value)
        }
    }

    fun navigateToCatalog() {
        navigator.navigateTo(AppNavRoute.Catalog)
    }
}