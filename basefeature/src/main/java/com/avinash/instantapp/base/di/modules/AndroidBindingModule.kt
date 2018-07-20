package com.avinash.instantapp.base.di.modules

import android.app.Application
import android.content.Context
import dagger.Binds
import dagger.Module

/**
 * {link @dagger.Module} class for providing application dependencies
 */
@Module
abstract class AndroidBindingModule {

    @Binds
    abstract fun bindsContext(app: Application): Context
}