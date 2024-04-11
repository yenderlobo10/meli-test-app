package com.test.meli.core.extensions

import com.test.meli.core.observability.AppLogger
import java.util.Locale

/**
 * Return an empty string if this is null.
 */
fun String?.emptyIfNull() = this ?: ""


/**
 * TODO: document function
 */
fun String.capitalize(): String = try {

    this.replaceFirstChar {
        if (it.isLowerCase()) it.titlecase(Locale.getDefault())
        else it.toString()
    }

} catch (ex: Exception) {

    AppLogger.warning(ex, ex.message)
    this
}

/**
 * TODO: document function
 */
fun String.capitalizeWords(): String = try {

    this.split(" ").joinToString(" ") { word ->

        word.replaceFirstChar {
            if (it.isLowerCase()) it.titlecase(Locale.getDefault())
            else it.toString()
        }
    }

} catch (ex: Exception) {

    AppLogger.warning(ex, ex.message)
    this
}