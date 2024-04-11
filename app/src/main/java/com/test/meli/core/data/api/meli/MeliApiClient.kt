package com.test.meli.core.data.api.meli

import com.test.meli.BuildConfig
import com.test.meli.core.data.api.ApiClient
import com.test.meli.core.data.api.common.addLogger
import com.test.meli.core.data.api.common.createHttpClient
import com.test.meli.core.data.api.common.createMoshiConverterFactoryOrDefault

class MeliApiClient : ApiClient() {

    override val baseUrl = "https://api.mercadolibre.com/"

    override val converterFactory = createMoshiConverterFactoryOrDefault()

    override val httpClient = createHttpClient()
        .addLogger(isDebug = BuildConfig.DEBUG)
        .build()
}