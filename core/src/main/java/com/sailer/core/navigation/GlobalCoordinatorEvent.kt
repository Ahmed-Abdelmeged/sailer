package com.sailer.core.navigation

/**
 * Created by Ahmed Abd-Elmeged on 6/30/20.
 */
sealed class GlobalCoordinatorEvent : CoordinatorEvent {

    object Back : GlobalCoordinatorEvent()
}