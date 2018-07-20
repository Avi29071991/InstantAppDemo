package com.avinash.instant.biometric.di

import com.avinash.instantapp.base.di.AppComponent
import com.avinash.instantapp.base.di.BaseModuleInjector
import com.avinash.instantapp.base.di.DaggerComponent
import dagger.android.AndroidInjector

/**
 * Class used to inject objects in dagger graph for Biometric modules
 */
object BiometricFeatureModuleInjector : BaseModuleInjector() {

    override fun moduleInjector(daggerComponent: DaggerComponent): AndroidInjector<out BaseModuleInjector> {
        /**
         * Returning dagger generated BIOMETRIC feature component as {link @AndroidInjector} object
         */
        return DaggerBiometricFeatureComponent.builder().appComponent(daggerComponent as AppComponent).build()
    }
}