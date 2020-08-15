package com.sailer.rider.presentation.navigation

import com.sailer.core.di.scopes.AppScope
import com.sailer.core.navigation.Coordinator
import com.sailer.core.navigation.FeatureNavigator
import com.sailer.core.navigation.GlobalCoordinatorEvent
import com.sailer.core.navigation.StartDestination
import com.sailer.rider.R
import com.sailer.shopping.presentation.view.ShoppingHostFragmentArgs
import javax.inject.Inject

/**
 * Created by Ahmed Abd-Elmeged on 6/1/20.
 */
@AppScope
class RiderCoordinator @Inject constructor(
    featureNavigator: FeatureNavigator
) : Coordinator(featureNavigator) {

    override fun onStart(): StartDestination {
        return StartDestination(destination = R.id.homeFragment)
    }

    override fun onEvent(event: Any): Boolean {
        when (event) {
            is GlobalCoordinatorEvent.Back -> if (navController?.popBackStack() == false) {
                activity?.finish()
            }
            is RiderCoordinatorEvent.Shopping -> shopping()
        }
        return true
    }

    private fun shopping() {
        val args = ShoppingHostFragmentArgs(categoryId = 1).toBundle()
        navController?.navigate(R.id.shoppingFragment, args)
    }
}