package com.sailer.core.navigation

import android.content.Context
import android.content.Intent
import com.sailer.actions.Actions
import javax.inject.Inject

/**
 * Created by Ahmed Abd-Elmeged on 5/6/20.
 */
class FeatureNavigatorImpl @Inject constructor(private val context: Context) : FeatureNavigator {

    override fun splash(): Intent {
        return Actions.openSplashIntent(context)
    }

    override fun rider(): Intent {
        return Actions.openRiderIntent(context)
    }

    override fun driver(): Intent {
        return Actions.openDriverIntent(context)
    }

    override fun auth(): Intent {
        TODO("Not yet implemented")
    }
}