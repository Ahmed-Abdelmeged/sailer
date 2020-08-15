package com.sailer.sailer.navigation

import com.sailer.auth.domain.usecase.GetLoginStatusUseCase
import com.sailer.core.navigation.Coordinator
import com.sailer.core.navigation.FeatureNavigator
import com.sailer.core.navigation.StartDestination
import com.sailer.sailer.BuildConfig
import javax.inject.Inject

/**
 * Created by Ahmed Abd-Elmeged on 6/1/20.
 */
class AppCoordinator @Inject constructor(
    featureNavigator: FeatureNavigator,
    private val getLoginStatusUseCase: GetLoginStatusUseCase
) : Coordinator(featureNavigator) {

    override fun onStart(): StartDestination {
        throw IllegalArgumentException("App coordinator navigate to activities only")
    }

    fun start() {
        val loginStatus = getLoginStatusUseCase.execute()
        val intent = if (loginStatus.isLoggedIn) {
            when (BuildConfig.FLAVOR) {
                "rider" -> featureNavigator.rider()
                "driver" -> featureNavigator.driver()
                else -> throw IllegalArgumentException("Not Implemented User role")
            }
        } else {
            featureNavigator.auth()
        }
        activity?.finish()
        activity?.startActivity(intent)
    }

    override fun onEvent(event: Any): Boolean {
        return true
    }
}
