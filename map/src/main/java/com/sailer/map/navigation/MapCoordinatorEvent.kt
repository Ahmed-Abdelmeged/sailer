package com.sailer.map.navigation

import com.sailer.core.navigation.CoordinatorEvent

/**
 * Created by Ahmed Abd-Elmeged on 6/17/20.
 */
sealed class MapCoordinatorEvent : CoordinatorEvent {
    object Back : MapCoordinatorEvent()
}