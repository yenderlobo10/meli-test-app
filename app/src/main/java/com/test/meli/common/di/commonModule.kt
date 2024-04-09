package com.test.meli.common.di

import com.test.meli.common.navigation.AppNavigator
import org.koin.dsl.module

val commonModule = module {

    single { AppNavigator() }
}