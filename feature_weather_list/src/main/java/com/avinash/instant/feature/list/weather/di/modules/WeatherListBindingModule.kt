package com.avinash.instant.feature.list.weather.di.modules

import com.avinash.instant.feature.list.weather.presentation.activity.WeatherListActivity
import com.avinash.instantapp.base.di.FeatureScreenScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * {link @dagger.Module} class for providing dependencies related Weather feature
 */
@Module
abstract class WeatherListBindingModule {

    /**
     * Need to provide {link @FeatureScreenScope} for injecting contents in {link @WeatherListActivity}
     * Also need to provide {link @WeatherListModule} which has DI objects created using {link @FeatureScreenScope} to be added in mentioned activity
     */
    @FeatureScreenScope
    @ContributesAndroidInjector(modules = arrayOf(WeatherListModule::class))
    abstract fun contributeWeatherListActivity(): WeatherListActivity
}