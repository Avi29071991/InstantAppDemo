package com.avinash.instantapp.base.presentation.activity

import android.support.v7.app.AppCompatActivity
import android.support.annotation.LayoutRes
import android.os.Bundle
import android.support.annotation.Nullable
import android.support.annotation.VisibleForTesting
import android.support.v7.widget.Toolbar
import com.avinash.instantapp.base.di.Injectable
import dagger.android.AndroidInjection

/**
 * Base Activity for this application
 */
abstract class BaseActivity : AppCompatActivity() {


    /**
     * @return the layout resource to use for this activity,
     *  or a value = 0 if no layout should be used
     */
    @LayoutRes
    protected abstract fun getLayoutResource(): Int


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layoutResId = getLayoutResource()
        if (layoutResId != 0) {
            setContentView(layoutResId)
        }
    }

    override fun setSupportActionBar(@Nullable toolbar: Toolbar?) {
        super.setSupportActionBar(toolbar)
        configureActionBar()
    }

    override fun setTitle(title: CharSequence) {
        super.setTitle(title)
        val actionBar = supportActionBar
        actionBar?.title = title
    }

    @VisibleForTesting
    protected fun configureActionBar() {
        val actionBar = supportActionBar
        actionBar?.elevation = 0F
    }

    protected fun setNavigationUp() {
        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }
}