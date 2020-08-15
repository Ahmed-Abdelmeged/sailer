package com.sailer.driver.presentation.navigation

import com.sailer.core.navigation.CoordinatorEvent

/**
 * Created by Ahmed Abd-Elmeged on 6/14/20.
 */
sealed class DriverCoordinatorEvent : CoordinatorEvent {

    object Logout : DriverCoordinatorEvent()

    object Map : DriverCoordinatorEvent()
}