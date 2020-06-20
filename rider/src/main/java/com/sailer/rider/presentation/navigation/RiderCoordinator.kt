package com.sailer.rider.presentation.navigation

import androidx.lifecycle.ViewModelProvider
import com.sailer.core.di.scopes.AppScope
import com.sailer.core.navigation.Coordinator
import com.sailer.core.navigation.Displayable
import com.sailer.core.navigation.FeatureNavigator
import com.sailer.core.navigation.StartDestination
import com.sailer.rider.R
import com.sailer.rider.presentation.home.view.HomeFragment
import com.sailer.rider.presentation.home.viewmodel.HomeViewModelFactory
import dagger.Lazy
import javax.inject.Inject

/**
 * Created by Ahmed Abd-Elmeged on 6/1/20.
 */
@AppScope
class RiderCoordinator @Inject constructor(
    featureNavigator: FeatureNavigator,
    private val homeViewModelFactory: Lazy<HomeViewModelFactory.Factory>
) : Coordinator(featureNavigator) {

    fun start(): StartDestination {
        return StartDestination(destination = R.id.homeFragment)
    }

    override fun onCreateViewModelFactory(screen: Displayable): ViewModelProvider.Factory {
        return when (screen) {
            is HomeFragment -> homeViewModelFactory.get().create()

            else -> throw IllegalArgumentException("Not supported fragment for the current coordinator")
        }
    }

    override fun onEvent(event: Any) {
        when (event) {
            is RiderCoordinatorEvent.Shopping -> shopping()
            is RiderCoordinatorEvent.Back -> back()
        }
    }

    private fun shopping() {
        activity?.startActivity(featureNavigator.shopping(50))
    }
}