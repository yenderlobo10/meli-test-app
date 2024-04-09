package com.test.meli

import android.app.Application
import com.test.meli.common.di.commonModule
import com.test.meli.common.observability.AppLogger
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
                searchModule
            )
        }

        AppLogger.setup()
    }
}