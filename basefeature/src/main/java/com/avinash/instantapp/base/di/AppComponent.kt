package com.avinash.instantapp.base.di

import android.app.Application
import com.avinash.instantapp.base.application.BaseFeatureApplication
import com.avinash.instantapp.base.di.modules.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

/**
 * {link @dagger.Component} class for application BASE feature
 */
@Singleton
@Component(modules = arrayOf(AndroidSupportInjectionModule::class, AndroidBindingModule::class, NetworkingModule::class, NetworkingBindingModule::class))
interface AppComponent : AndroidInjector<BaseFeatureApplication>, DaggerComponent, ComponentProvider {
    /**
     *  {link @dagger.Component} component class used to provide application class objects which will be injected in evey features
     */

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): AppComponent.Builder

        fun build(): AppComponent
    }

    override fun inject(app: BaseFeatureApplication)
}