package com.avinash.instant.feature.list.weather.di

import com.avinash.instant.feature.list.weather.di.modules.WeatherListBindingModule
import com.avinash.instantapp.base.di.AppComponent
import com.avinash.instantapp.base.di.DaggerComponent
import com.avinash.instantapp.base.di.FeatureModuleScope
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

/**
 * {{link @dagger.Component} class for Weather feature.
 * Need to provide {@FeatureModuleScope} to add dependencies for Weather feature
 */
@FeatureModuleScope
@Component(
        dependencies = arrayOf(AppComponent::class),
        modules = arrayOf(AndroidSupportInjectionModule::class, WeatherListBindingModule::class)
)
interface WeatherListAppFeatureComponent : AndroidInjector<WeatherListFeatureModuleInjector>, DaggerComponent {
    /**
     *  {link @Component} component class used to provide additional classes to be injected in base feature classes apart from the universal
     *  class objects which will be injected in evey features
     */
}