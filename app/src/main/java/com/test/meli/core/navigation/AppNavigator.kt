package com.test.meli.core.navigation

import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow

class AppNavigator {

    private val _sharedFlow = MutableSharedFlow<AppNavRoute>(
        extraBufferCapacity = 1,
        onBufferOverflow = BufferOverflow.DROP_OLDEST
    )
    val sharedFlow = _sharedFlow.asSharedFlow()

    fun navigateTo(route: AppNavRoute) {
        _sharedFlow.tryEmit(route)
    }
}