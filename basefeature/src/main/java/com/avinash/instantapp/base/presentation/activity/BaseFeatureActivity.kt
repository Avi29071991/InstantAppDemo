package com.avinash.instantapp.base.presentation.activity

import android.os.Bundle
import com.avinash.instantapp.base.di.Injectable
import com.avinash.instantapp.base.di.base.BaseFeatureLaunchInjector

/**
 * Base Activity for Launch feature which injects Launch feature components
 */
abstract class BaseFeatureActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (this is Injectable) {
            BaseFeatureLaunchInjector.inject(this)
        }
    }
}