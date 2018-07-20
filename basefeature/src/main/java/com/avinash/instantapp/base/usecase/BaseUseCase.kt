package com.avinash.instantapp.base.usecase

import rx.Observable
import rx.Subscriber
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subscriptions.Subscriptions

/**
 * Base usecase class which will be used by usecase class of other non-base feature modules
 */
abstract class BaseUseCase {
    private var subscription = Subscriptions.empty()
    protected abstract fun buildUseCaseObservable(): Observable<*>

    /**
     * Method used to execute a usecase with the help of {link @rx.Observable}
     */
    fun execute(useCaseSubscriber: Subscriber<Any>) {
        this.subscription = this.buildUseCaseObservable().subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread()).subscribe(useCaseSubscriber)
    }

    /**
     * Method used to unsubscribe a usecase
     */
    fun unSubscribe() {
        if (!this.subscription.isUnsubscribed) {
            this.subscription.unsubscribe()
        }
    }
}