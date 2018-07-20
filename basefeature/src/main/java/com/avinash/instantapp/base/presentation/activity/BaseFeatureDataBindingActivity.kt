package com.avinash.instantapp.base.presentation.activity

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle

/**
 * Base Activity for providing DataBinding compatibility
 */
abstract class BaseFeatureDataBindingActivity<T : ViewDataBinding> : BaseActivity() {

    lateinit var binding: T

    fun getActivityBinding(): T {
        return binding
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (getLayoutResource() != 0) {
            binding = DataBindingUtil.setContentView<T>(this, getLayoutResource())
        }
    }
}