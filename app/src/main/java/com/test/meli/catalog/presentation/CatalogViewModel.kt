package com.test.meli.catalog.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.meli.catalog.domain.ProductItem
import com.test.meli.catalog.domain.SearchProductsUseCase
import com.test.meli.core.navigation.AppNavRoute
import com.test.meli.core.navigation.AppNavigator
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class CatalogViewModel(
    savedStateHandle: SavedStateHandle,
    val navigator: AppNavigator,
    val searchProductsUseCase: SearchProductsUseCase
) : ViewModel() {

    private val q = checkNotNull(savedStateHandle.get<String>("q"))
    private val _catalogState = MutableStateFlow(CatalogState())
    val catalogState: StateFlow<CatalogState> = _catalogState

    init {
        searchProducts()
    }

    private fun searchProducts() {
        viewModelScope.launch {
            runCatching {
                searchProductsUseCase(q = q)
            }.onSuccess { products ->
                _catalogState.update {
                    it.copy(
                        isLoading = false,
                        products = products
                    )
                }
            }.onFailure {
                _catalogState.update {
                    it.copy(
                        isLoading = false,
                        isError = true
                    )
                }
            }
        }
    }

    fun navigateToProductDetail(item: ProductItem) {
        navigator.navigateTo(
            AppNavRoute.ProductDetail(id = item.id)
        )
    }
}