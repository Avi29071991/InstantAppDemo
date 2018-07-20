package com.avinash.instant.biometric.di.module

import com.avinash.instant.biometric.presentation.BiometricMainDisplayActivity
import com.avinash.instantapp.base.di.FeatureScreenScope
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * {link @dagger.Module} class for providing dependencies related Biometric feature
 */
@Module
abstract class BiometricBindingModule {

    /**
     * Need to provide {link @FeatureScreenScope} for injecting contents in {link @BiometricMainDisplayActivity}.
     */
    @FeatureScreenScope
    @ContributesAndroidInjector
    abstract fun contributesBiometricDisplayActivity(): BiometricMainDisplayActivity
}