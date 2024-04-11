package com.test.meli.core.di

import com.test.meli.core.data.api.meli.MeliApiClient
import com.test.meli.core.data.api.meli.MeliCatalogService
import com.test.meli.core.navigation.AppNavigator
import org.koin.dsl.module
import retrofit2.Retrofit

fun provideMeliApiClient(): Retrofit = MeliApiClient().retrofit()

fun provideMeliCatalogService(meliApiClient: Retrofit): MeliCatalogService =
    meliApiClient.create(MeliCatalogService::class.java)

val commonModule = module {

    single { AppNavigator() }

    single { provideMeliApiClient() }

    single<MeliCatalogService> { provideMeliCatalogService(get()) }
}