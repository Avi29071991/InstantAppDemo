package com.avinash.instant.biometric.di

import com.avinash.instant.biometric.di.module.BiometricBindingModule
import com.avinash.instantapp.base.di.AppComponent
import com.avinash.instantapp.base.di.DaggerComponent
import com.avinash.instantapp.base.di.FeatureModuleScope
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

/**
 * {{link @dagger.Component} class for Biometric feature.
 * Need to provide {@FeatureModuleScope} to add dependencies for Biometric feature
 */
@FeatureModuleScope
@Component(
        dependencies = arrayOf(AppComponent::class),
        modules = arrayOf(AndroidSupportInjectionModule::class, BiometricBindingModule::class)
)
interface BiometricFeatureComponent : AndroidInjector<BiometricFeatureModuleInjector>, DaggerComponent {
    /**
     *  {link @dagger.Component} component class used to provide additional classes to be injected in biometric feature classes apart from the application
     *  class objects which will be injected in evey features
     */
}