package com.avinash.instantapp.base.di.modules

import com.avinash.instantapp.base.di.FeatureScreenScope
import com.avinash.instantapp.base.presentation.activity.LaunchActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * {link @dagger.Module} class for providing dependencies related launch feature
 */
@Module
abstract class LaunchBindingModule {

    /**
     * Need to provide {link @FeatureScreenScope} for injecting contents in {link @LaunchActivity}
     */
    @FeatureScreenScope
    @ContributesAndroidInjector
    abstract fun contributesLaunchActivity(): LaunchActivity
}