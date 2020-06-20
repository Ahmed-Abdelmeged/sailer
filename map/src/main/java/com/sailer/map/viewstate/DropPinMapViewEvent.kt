package com.sailer.map.viewstate

import com.sailer.core.viewstate.ViewEvent
import com.sailer.map.model.Location

/**
 * Created by Ahmed Abd-Elmeged on 6/10/20.
 */
sealed class DropPinMapViewEvent : ViewEvent {

    data class SetDropPinLocation(val location: Location) : DropPinMapViewEvent()

    object MissingLocation : DropPinMapViewEvent()
}