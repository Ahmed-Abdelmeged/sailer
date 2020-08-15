package com.sailer.core.navigation

import android.content.Intent

/**
 * Created by Ahmed Abd-Elmeged on 5/6/20.
 */
interface FeatureNavigator {

    fun splash(): Intent

    fun driver(): Intent

    fun rider(): Intent

    fun auth(): Intent
}