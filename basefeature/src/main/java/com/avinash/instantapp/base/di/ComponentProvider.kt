package com.avinash.instantapp.base.di

import android.content.Context
import com.avinash.instantapp.base.data.DataProvider

/**
 * Interface used to provide dagger injected objects in different non-base feature modules
 */
interface ComponentProvider {
    fun getDataProvider(): DataProvider

    fun getContext(): Context
}