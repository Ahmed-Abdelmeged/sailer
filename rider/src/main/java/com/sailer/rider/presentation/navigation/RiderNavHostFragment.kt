package com.sailer.rider.presentation.navigation

import com.sailer.core.di.activityScopedComponent
import com.sailer.core.navigation.InjectingNavHostFragment
import com.sailer.rider.di.RiderComponent

/**
 * Created by Ahmed Abd-Elmeged on 7/24/20.
 */
class RiderNavHostFragment : InjectingNavHostFragment() {

    override fun onPerformInjection() {
        activityScopedComponent<RiderComponent>().inject(this)
    }
}