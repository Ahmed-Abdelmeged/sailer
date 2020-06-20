package com.sailer.sailer.navigation

import com.sailer.core.navigation.CoordinatorEvent

/**
 * Created by Ahmed Abd-Elmeged on 6/20/20.
 */
sealed class AppCoordinatorEvent : CoordinatorEvent {
    object Start : AppCoordinatorEvent()
}