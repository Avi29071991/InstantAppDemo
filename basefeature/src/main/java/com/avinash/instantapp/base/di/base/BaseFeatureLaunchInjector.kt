package com.avinash.instantapp.base.di.base

import com.avinash.instantapp.base.di.AppComponent
import com.avinash.instantapp.base.di.BaseModuleInjector
import com.avinash.instantapp.base.di.DaggerComponent
import dagger.android.AndroidInjector

/**
 * Class used to inject objects in dagger graph for Launch modules
 */
object BaseFeatureLaunchInjector : BaseModuleInjector() {
    override fun moduleInjector(daggerComponent: DaggerComponent): AndroidInjector<out BaseModuleInjector> {
        /**
         * Returning dagger generated LAUNCH feature component as {link @AndroidInjector} object
         */
        return DaggerBaseFeatureLaunchComponent.builder().appComponent(daggerComponent as AppComponent).build()
    }
}