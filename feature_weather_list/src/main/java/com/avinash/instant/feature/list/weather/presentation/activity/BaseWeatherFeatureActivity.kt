package com.avinash.instant.feature.list.weather.presentation.activity

import android.os.Bundle
import com.avinash.instant.feature.list.weather.di.WeatherListFeatureModuleInjector
import com.avinash.instantapp.base.di.Injectable
import com.avinash.instantapp.base.presentation.activity.BaseActivity

/**
 * Base Activity for Launch feature which injects Weather feature components
 */
abstract class BaseWeatherFeatureActivity : BaseActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (this is Injectable) {
            WeatherListFeatureModuleInjector.inject(this)
        }
    }
}