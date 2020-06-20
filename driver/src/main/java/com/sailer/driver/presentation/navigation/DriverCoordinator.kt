package com.sailer.driver.presentation.navigation

import androidx.lifecycle.ViewModelProvider
import com.sailer.core.di.scopes.AppScope
import com.sailer.core.navigation.Coordinator
import com.sailer.core.navigation.Displayable
import com.sailer.core.navigation.FeatureNavigator
import com.sailer.core.navigation.StartDestination
import com.sailer.driver.R
import com.sailer.driver.presentation.arrived.view.ArrivedFragment
import com.sailer.driver.presentation.arrived.viewmodel.ArrivedViewModelFactory
import com.sailer.map.navigation.MapCoordinatorEvent
import com.sailer.map.view.DropPinMapFragment
import com.sailer.map.viewmodel.DropPinMapViewModelFactory
import dagger.Lazy
import javax.inject.Inject

/**
 * Created by Ahmed Abd-Elmeged on 6/1/20.
 */
@AppScope
class DriverCoordinator @Inject constructor(
    featureNavigator: FeatureNavigator,
    private val arrivedViewModelFactory: Lazy<ArrivedViewModelFactory.Factory>,
    private val dropPinMapViewModelFactory: Lazy<DropPinMapViewModelFactory.Factory>
) : Coordinator(featureNavigator) {

    fun start(): StartDestination {
        return StartDestination(destination = R.id.arrivedFragment)
    }

    override fun onCreateViewModelFactory(screen: Displayable): ViewModelProvider.Factory {
        return when (screen) {
            is ArrivedFragment -> arrivedViewModelFactory.get().create()

            is DropPinMapFragment -> dropPinMapViewModelFactory.get().create()

            else -> throw IllegalArgumentException("Not supported fragment for the current coordinator")
        }
    }

    override fun onEvent(event: Any) {
        when (event) {
            is DriverCoordinatorEvent.Map -> map()
            is DriverCoordinatorEvent.Back -> back()
            is DriverCoordinatorEvent.Logout -> logout()
            is MapCoordinatorEvent.Back -> back()
        }
    }

    private fun map() {
        navController?.navigate(R.id.dropPinMapFragment)
    }

    private fun logout() {
        activity?.startActivity(featureNavigator.splash())
    }
}