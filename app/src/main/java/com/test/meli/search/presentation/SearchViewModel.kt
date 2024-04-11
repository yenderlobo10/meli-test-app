package com.test.meli.search.presentation

import androidx.lifecycle.ViewModel
import com.test.meli.core.navigation.AppNavRoute
import com.test.meli.core.navigation.AppNavigator
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
        if (searchState.value.isValidQuery.not())
            validateQuery()

        _searchState.update {
            it.copy(query = value)
        }
    }

    fun navigateToCatalog() {
        validateQuery()

        if (searchState.value.isValidQuery.not()) return

        navigator.navigateTo(
            AppNavRoute.Catalog(
                query = searchState.value.query
            )
        )
    }

    private fun validateQuery(){
        val isValidQuery = Regex("^[\\w ]{3,}$").matches(searchState.value.query)

        _searchState.update {
            it.copy(isValidQuery = isValidQuery)
        }
    }
}