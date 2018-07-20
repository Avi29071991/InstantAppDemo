package com.avinash.instantapp.base.di

import javax.inject.Scope

/**
 * Scope created for indicating DI objects to be created, cached and available for classes with created scope
 */
@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class FeatureScreenScope