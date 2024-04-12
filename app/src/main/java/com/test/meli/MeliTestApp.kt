package com.test.meli

import android.app.Application
import com.test.meli.catalog.di.catalogModule
import com.test.meli.core.di.apiModule
import com.test.meli.core.di.commonModule
import com.test.meli.core.observability.AppLogger
import com.test.meli.productdetail.di.productDetailModule
import com.test.meli.search.di.searchModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MeliTestApp : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MeliTestApp)
            androidLogger()
            modules(
                commonModule,
                apiModule,
                searchModule,
                catalogModule,
                productDetailModule
            )
        }

        AppLogger.setup()
    }
}