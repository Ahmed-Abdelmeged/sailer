package com.sailer.core.di

import android.app.Activity
import android.content.Context

/**
 * Created by Ahmed Abd-Elmeged on 4/26/20.
 */

fun Activity.provideCoreComponent(): CoreComponent {
    return provideCoreComponent(applicationContext)
}

private fun provideCoreComponent(applicationContext: Context): CoreComponent {
    return if (applicationContext is CoreComponentProvider) {
        (applicationContext as CoreComponentProvider).provideCoreComponent()
    } else {
        throw IllegalStateException("The application context you have passed does not implement CoreComponentProvider")
    }
}