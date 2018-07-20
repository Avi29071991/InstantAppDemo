package com.avinash.instantapp.base.di.modules

import com.avinash.weatherapp.network.datasource.ApiDataSource
import com.avinash.weatherapp.network.implementation.ApiDataSourceImplementor
import dagger.Binds
import dagger.Module

/**
 * {link @dagger.Module} class for providing dependencies related to api implementation
 */
@Module
abstract class NetworkingBindingModule {
    @Binds
    abstract fun bindsApiDataSource(apiDataSourceImplementor: ApiDataSourceImplementor): ApiDataSource
}