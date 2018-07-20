package com.avinash.instantapp.base.presentation.view

/**
 * Base view for the application which contains method which will be used by other non-base feature modules
 */
interface BaseView {

    fun showProgressBar()

    fun hideProgressBar()

    fun showErrorMessage(show: Boolean, errorMessage: String?)

}