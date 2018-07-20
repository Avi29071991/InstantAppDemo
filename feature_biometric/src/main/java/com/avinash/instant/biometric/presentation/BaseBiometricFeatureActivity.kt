package com.avinash.instant.biometric.presentation

import android.os.Bundle
import com.avinash.instant.biometric.di.BiometricFeatureModuleInjector
import com.avinash.instantapp.base.di.Injectable
import com.avinash.instantapp.base.presentation.activity.BaseActivity
import com.avinash.instantapp.base.presentation.activity.BaseFeatureActivity

/**
 * Base Activity for Launch feature which injects Biometric feature components
 */
abstract class BaseBiometricFeatureActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (this is Injectable) {
            BiometricFeatureModuleInjector.inject(this)
        }
    }
}