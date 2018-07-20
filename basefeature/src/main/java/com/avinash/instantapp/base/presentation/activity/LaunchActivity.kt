package com.avinash.instantapp.base.presentation.activity

import android.content.Context
import android.os.Bundle
import com.avinash.instantapp.base.R
import kotlinx.android.synthetic.main.activity_launch.*
import android.content.Intent
import android.net.Uri
import com.avinash.instantapp.base.di.Injectable
import javax.inject.Inject


/**
 * Activity for launch feature
 */
class LaunchActivity : BaseFeatureActivity(), Injectable {

    lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setOnClickListeners()
    }

    override fun getLayoutResource(): Int {
        return R.layout.activity_launch
    }

    /**
     * Click listeners for navigating to activities in other non-base feature modules.
     * For both full installable applications and instant apps this way of navigation using urls will work
     */
    private fun setOnClickListeners() {
        btnNavigateBiometric.setOnClickListener {
            navigateActivity("http://avinash.biometric.instantapp.com/main/")
        }
        btnNavigateWeather.setOnClickListener {
            navigateActivity("http://avinash.weather.instantapp.com/list/")
        }
    }

    private fun navigateActivity(url: String) {
        val intent = Intent(Intent.ACTION_VIEW,
                Uri.parse(url))
        intent.`package` = context.packageName
        intent.addCategory(Intent.CATEGORY_BROWSABLE)
        startActivity(intent)
    }

    @Inject
    fun setActivityContext(ctx: Context) {
        this.context = ctx
    }
}