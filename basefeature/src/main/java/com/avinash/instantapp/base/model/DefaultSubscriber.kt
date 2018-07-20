package com.avinash.instantapp.base.model

import rx.Subscriber

/**
 * Custom Subscriber class used for performing actions provided by {link @rx.Observables}
 */
open class DefaultSubscriber<T> : Subscriber<T>() {

    override fun onCompleted() {}

    override fun onError(e: Throwable) {}

    override fun onNext(t: T) {}
}
