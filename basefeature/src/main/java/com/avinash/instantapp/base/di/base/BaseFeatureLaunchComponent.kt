package com.avinash.instantapp.base.di.base

import com.avinash.instantapp.base.di.AppComponent
import com.avinash.instantapp.base.di.DaggerComponent
import com.avinash.instantapp.base.di.FeatureModuleScope
import com.avinash.instantapp.base.di.modules.LaunchBindingModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

/**
 * {{link @dagger.Component} class for Launch feature.
 * Need to provide {@FeatureModuleScope} to add dependencies for Launch feature
 */
@FeatureModuleScope
@Component(
        dependencies = arrayOf(AppComponent::class),
        modules = arrayOf(AndroidSupportInjectionModule::class, LaunchBindingModule::class)
)
interface BaseFeatureLaunchComponent : AndroidInjector<BaseFeatureLaunchInjector>, DaggerComponent {
    /**
     *  {link @dagger.Component} component class used to provide additional classes to be injected in base feature classes apart from the application
     *  class objects which will be injected in evey features
     */
}