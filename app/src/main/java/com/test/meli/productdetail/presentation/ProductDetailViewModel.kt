package com.test.meli.productdetail.presentation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.meli.core.navigation.AppNavigator
import com.test.meli.productdetail.domain.ProductDetailRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ProductDetailViewModel(
    savedStateHandle: SavedStateHandle,
    private val navigator: AppNavigator,
    private val productDetailRepository: ProductDetailRepository
) : ViewModel() {

    private val id = checkNotNull(savedStateHandle.get<String>("id"))
    private val _detailState = MutableStateFlow(ProductDetailState())
    val detailState: StateFlow<ProductDetailState> = _detailState

    init {
        loadDetail()
    }

    private fun loadDetail() {
        viewModelScope.launch {
            delay(900)
            try {

                val detail = productDetailRepository.getDetail(id)
                _detailState.update {
                    it.copy(
                        isLoading = false,
                        detail = detail
                    )
                }

            } catch (ex: Throwable) {
                _detailState.update {
                    it.copy(
                        isLoading = false,
                        isError = true
                    )
                }
            }
        }
    }
}