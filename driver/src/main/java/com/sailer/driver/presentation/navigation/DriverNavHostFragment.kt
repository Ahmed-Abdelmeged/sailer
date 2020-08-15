package com.sailer.driver.presentation.navigation

import com.sailer.core.di.activityScopedComponent
import com.sailer.core.navigation.InjectingNavHostFragment
import com.sailer.driver.di.DriverComponent

/**
 * Created by Ahmed Abd-Elmeged on 7/24/20.
 */
class DriverNavHostFragment : InjectingNavHostFragment() {

    override fun onPerformInjection() {
        activityScopedComponent<DriverComponent>().inject(this)
    }
}