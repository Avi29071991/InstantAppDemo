package com.avinash.instantapp.base.application

import android.content.Context
import android.support.multidex.MultiDex
import dagger.android.AndroidInjector
import com.avinash.instantapp.base.di.DaggerAppComponent
import dagger.android.support.DaggerApplication


/**
 * Class for the installable and instant applications which is inherited from DaggerApplication class inturn a child of Application class
 */
class BaseFeatureApplication : DaggerApplication() {

    /**
     * Auto generated instance of app component which is the base class for components in different feature modules
     */
    private val appComponent = DaggerAppComponent.builder().application(this).build()

    companion object {
        /**
         * Method used to provide different
         */
        fun appComponent(context: Context) = (context.applicationContext as BaseFeatureApplication).appComponent
    }

    /**
     * Method from DaggerApplication class useful in injecting components {link @dagger.Component} from different modules
     */
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return appComponent.apply { inject(this@BaseFeatureApplication) }
    }

    override fun onCreate() {
        super.onCreate()
        /**
         * Can perform actions which are required to be performed when application starts
         */
    }


    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        /**
         * Performing actions for getting rid of multidex issues
         */
        MultiDex.install(this)
    }
}