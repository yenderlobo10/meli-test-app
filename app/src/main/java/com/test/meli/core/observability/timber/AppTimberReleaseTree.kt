package com.test.meli.core.observability.timber

import timber.log.Timber

/**
 * Implement Timber logger to production flavor.
 *
 * @see Timber
 */
class AppTimberReleaseTree : Timber.Tree() {

    override fun log(
        priority: Int,
        tag: String?,
        message: String,
        t: Throwable?
    ) {
        // TODO: implement service to register logs
    }
}