package com.test.meli.catalog.di

import com.test.meli.catalog.data.CatalogRemoteSource
import com.test.meli.catalog.data.CatalogRemoteSourceImpl
import com.test.meli.catalog.data.CatalogRepositoryImpl
import com.test.meli.catalog.domain.CatalogRepository
import com.test.meli.catalog.domain.SearchProductsUseCase
import com.test.meli.catalog.presentation.CatalogViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val catalogModule = module {

    factory<CatalogRemoteSource> { CatalogRemoteSourceImpl(get()) }

    factory<CatalogRepository> { CatalogRepositoryImpl(get()) }

    factory { SearchProductsUseCase(get()) }

    viewModel { CatalogViewModel(get(), get(), get()) }
}