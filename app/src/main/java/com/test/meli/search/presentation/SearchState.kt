package com.test.meli.search.presentation

import androidx.compose.runtime.Stable

@Stable
data class SearchState(
    val query: String = "",
    val isValidQuery: Boolean = true
)