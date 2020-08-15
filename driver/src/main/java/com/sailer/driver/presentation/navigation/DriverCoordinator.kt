package com.sailer.driver.presentation.navigation

import com.sailer.core.di.scopes.AppScope
import com.sailer.core.navigation.Coordinator
import com.sailer.core.navigation.FeatureNavigator
import com.sailer.core.navigation.GlobalCoordinatorEvent
import com.sailer.core.navigation.StartDestination
import com.sailer.driver.R
import javax.inject.Inject

/**
 * Created by Ahmed Abd-Elmeged on 6/1/20.
 */
@AppScope
class DriverCoordinator @Inject constructor(
    featureNavigator: FeatureNavigator
) : Coordinator(featureNavigator) {

    override fun onStart(): StartDestination {
        return StartDestination(destination = R.id.arrivedFragment, args = null)
    }

    override fun onEvent(event: Any): Boolean {
        when (event) {
            is GlobalCoordinatorEvent.Back -> if (navController?.popBackStack() == false) {
                activity?.finish()
            }
            is DriverCoordinatorEvent.Map -> map()
            is DriverCoordinatorEvent.Logout -> logout()
        }
        return true
    }

    private fun map() {
        navController?.navigate(R.id.dropPinMapFragment)
    }

    private fun logout() {
        activity?.startActivity(featureNavigator.splash())
    }
}