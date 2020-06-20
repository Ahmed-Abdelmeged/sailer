package com.sailer.rider.presentation.navigation

import com.sailer.core.navigation.CoordinatorEvent

/**
 * Created by Ahmed Abd-Elmeged on 6/14/20.
 */
sealed class RiderCoordinatorEvent : CoordinatorEvent {

    object Shopping : RiderCoordinatorEvent()

    object Back : RiderCoordinatorEvent()
}