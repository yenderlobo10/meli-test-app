package com.test.meli.core.extensions

import com.test.meli.core.observability.AppLogger
import java.math.RoundingMode
import java.text.NumberFormat
import java.util.Currency
import java.util.Locale


/**
 * TODO: document function
 */
fun Double.toCurrencyFormat(
    locale: Locale = Locale.getDefault(),
    decimals: Int = 0,
    currencyCode: String? = null
): String = try {

    NumberFormat.getCurrencyInstance(locale).apply {

        minimumFractionDigits = decimals
        maximumFractionDigits = decimals
        this.roundingMode = RoundingMode.FLOOR

        if (currencyCode.isNullOrBlank().not())
            this.currency = Currency.getInstance(currencyCode)

    }.format(this)

} catch (ex: Exception) {

    AppLogger.warning(ex)
    this.toString()
}
