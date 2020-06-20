package com.sailer.map.viewstate

import com.sailer.core.viewstate.ViewAction
import com.sailer.map.model.Location

/**
 * Created by Ahmed Abd-Elmeged on 6/10/20.
 */
sealed class DropPinMapViewAction : ViewAction {
    object ClickOnBack : DropPinMapViewAction()

    data class DropPinLocation(val location: Location) : DropPinMapViewAction()

    object ConfirmDropPin : DropPinMapViewAction()
}