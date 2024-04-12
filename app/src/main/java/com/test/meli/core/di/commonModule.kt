package com.test.meli.core.di

import com.test.meli.core.navigation.AppNavigator
import org.koin.dsl.module


val commonModule = module {

    single { AppNavigator() }
}