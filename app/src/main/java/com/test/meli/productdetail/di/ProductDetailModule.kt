package com.test.meli.productdetail.di

import com.test.meli.productdetail.data.ProductDetailRemoteSource
import com.test.meli.productdetail.data.ProductDetailRemoteSourceImpl
import com.test.meli.productdetail.data.ProductDetailRepositoryImpl
import com.test.meli.productdetail.domain.ProductDetailRepository
import com.test.meli.productdetail.presentation.ProductDetailViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val productDetailModule = module {

    factory<ProductDetailRemoteSource> { ProductDetailRemoteSourceImpl(get()) }

    factory<ProductDetailRepository> { ProductDetailRepositoryImpl(get()) }

    viewModel { ProductDetailViewModel(get(), get(), get()) }
}