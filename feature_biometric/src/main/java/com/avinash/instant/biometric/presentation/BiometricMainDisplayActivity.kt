package com.avinash.instant.biometric.presentation

import android.content.Context
import android.hardware.biometrics.BiometricPrompt
import android.os.Bundle
import android.content.DialogInterface
import android.os.Build
import android.os.CancellationSignal
import android.widget.Toast
import android.widget.Button
import com.avinash.instant.biometric.R
import com.avinash.instantapp.base.di.Injectable
import javax.inject.Inject

/**
 * Activity for Biometric feature
 */
class BiometricMainDisplayActivity : BaseBiometricFeatureActivity(), Injectable {

    lateinit var context: Context
    private var btnBiometricDisplay: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeUIComponent()
    }

    override fun getLayoutResource(): Int {
        return R.layout.activity_main
    }

    /**
     * Need to initialize UI elements as kotlin synthtic view extensions not supported for non-base feature module.
     * Also Data binding is not supported for non-base feature module, but according to some android blog-post these features
     * are supported in Android Studio 3.1.0 and above .... Need to test
     */
    private fun initializeUIComponent() {
        btnBiometricDisplay = findViewById(R.id.btnNavigateBiometric)
        btnBiometricDisplay?.setOnClickListener {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                showBiometricAuthDialog()
            } else {
                showMessage("BiometricPrompt is available for Android P and above")
            }
        }
    }

    /**
     * Method used to show BiometricPrompt Dialog which hsa been included in android P (api 9.0 or sdk version 28) and above
     */
    private fun showBiometricAuthDialog() {
        val cancellationSignal = CancellationSignal()
        cancellationSignal.setOnCancelListener {
            showMessage("CancellationListener setOnCancelListener triggered")
        }

        /**
         * Currently BiometricPrompt API is supported only in Android P(version 28) devices.
         * For devices below Android version 28 Google is planning to provide Biometric Prompt Support Compat Library.
         * This will be released in subsequent versions. We can use CryptoObject variable as well in authenticate method for more stronger authentication
         * @link https://developer.android.com/reference/android/hardware/biometrics/BiometricPrompt.html#authenticate(android.hardware.biometrics.BiometricPrompt.CryptoObject,%20android.os.CancellationSignal,%20java.util.concurrent.Executor,%20android.hardware.biometrics.BiometricPrompt.AuthenticationCallback
         */
        BiometricPrompt.Builder(context)
                .setDescription("Test Biometric Dialog")
                .setTitle("Biometric dialog")
                .setNegativeButton("Cancel", mainExecutor, DialogInterface.OnClickListener { dialogInterface, i ->
                    showMessage("Cancel button clicked")
                })
                .build()
                .authenticate(cancellationSignal, mainExecutor, object : BiometricPrompt.AuthenticationCallback() {
                    override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult?) {
                        super.onAuthenticationSucceeded(result)
                        showMessage("Authentication successful")
                    }

                    override fun onAuthenticationFailed() {
                        super.onAuthenticationFailed()
                        /**
                         * Authentication failure takes place if we provide incorrect or unknown biometric credentials
                         */
                        showMessage("Authentication Failed")
                    }

                    override fun onAuthenticationError(errorCode: Int, errString: CharSequence?) {
                        super.onAuthenticationError(errorCode, errString)
                        /**
                         * Authentication errors can be of different types like lockout, hardware problems, issues in captured biometrics, timeouts,
                         * vendor error, etc.
                         */
                        showMessage("Authentication Error $errorCode $errString")
                        when (errorCode) {
                            BiometricPrompt.BIOMETRIC_ERROR_LOCKOUT_PERMANENT,
                            BiometricPrompt.BIOMETRIC_ERROR_LOCKOUT,
                            BiometricPrompt.BIOMETRIC_ERROR_CANCELED,
                            BiometricPrompt.BIOMETRIC_ERROR_HW_NOT_PRESENT,
                            BiometricPrompt.BIOMETRIC_ERROR_HW_UNAVAILABLE -> {
                                showMessage("Biometric hardware and lockout issues")
                            }
                            BiometricPrompt.BIOMETRIC_ERROR_NO_SPACE,
                            BiometricPrompt.BIOMETRIC_ERROR_NO_BIOMETRICS -> {
                                showMessage("Biometric settings changes i.e either biometric is removed or error while adding biometric")
                            }
                            BiometricPrompt.BIOMETRIC_ERROR_USER_CANCELED -> {
                                showMessage("User presses back button when biometric dialog is displayed")
                            }
                            BiometricPrompt.BIOMETRIC_ERROR_TIMEOUT,
                            BiometricPrompt.BIOMETRIC_ERROR_VENDOR,
                            BiometricPrompt.BIOMETRIC_ERROR_UNABLE_TO_PROCESS -> {
                                showMessage("Biometric timeout, vendor or processing errors")
                            }
                            else -> {
                                showMessage("Generic biometric error")
                            }

                        }
                    }

                    override fun onAuthenticationHelp(helpCode: Int, helpString: CharSequence?) {
                        super.onAuthenticationHelp(helpCode, helpString)
                        /**
                         * Help provided by biometric dialog during authentication
                         */
                        showMessage("Authentication Error $helpCode $helpString")
                        when (helpCode) {
                            BiometricPrompt.BIOMETRIC_ACQUIRED_IMAGER_DIRTY,
                            BiometricPrompt.BIOMETRIC_ACQUIRED_INSUFFICIENT,
                            BiometricPrompt.BIOMETRIC_ACQUIRED_PARTIAL,
                            BiometricPrompt.BIOMETRIC_ACQUIRED_TOO_FAST,
                            BiometricPrompt.BIOMETRIC_ACQUIRED_TOO_SLOW -> {
                                showMessage("Quality of image while IRIS and Face scan is blurry OR biometric moved fast or slow")
                            }
                            else -> {
                                showMessage("Generic biometric help")
                            }
                        }
                    }
                })
    }

    /**
     * Method used to display message using a Toast.
     * @param message String message to be displayed
     */
    fun showMessage(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    @Inject
    fun setActivityContext(ctx: Context) {
        this.context = ctx
    }

}