package com.sailer.driver.presentation.arrived.viewstate

import com.sailer.core.viewstate.ViewAction
import com.sailer.map.model.Location

/**
 * Created by Ahmed Abd-Elmeged on 6/5/20.
 */
sealed class ArrivedViewAction : ViewAction {

    object ClickOnBack : ArrivedViewAction()

    object OpenMap : ArrivedViewAction()

    data class DropPinLocation(val location: Location) : ArrivedViewAction()
}