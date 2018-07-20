package com.avinash.instant.feature.list.weather.di

import com.avinash.instantapp.base.di.AppComponent
import com.avinash.instantapp.base.di.BaseModuleInjector
import com.avinash.instantapp.base.di.DaggerComponent
import dagger.android.AndroidInjector

/**
 * Class used to inject objects in dagger graph for weather modules
 */
object WeatherListFeatureModuleInjector : BaseModuleInjector() {

    override fun moduleInjector(daggerComponent: DaggerComponent): AndroidInjector<out BaseModuleInjector> {
        /**
         * Returning dagger generated WEATHER feature component as {link @AndroidInjector} object
         */
        return DaggerWeatherListAppFeatureComponent.builder().appComponent(daggerComponent as AppComponent).build()
    }
}