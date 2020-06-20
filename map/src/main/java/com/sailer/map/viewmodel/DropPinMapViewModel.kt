package com.sailer.map.viewmodel

import com.sailer.core.base.viewmodel.BaseViewModel
import com.sailer.core.extension.exhaustive
import com.sailer.map.model.Location
import com.sailer.map.navigation.MapCoordinatorEvent
import com.sailer.map.viewstate.DropPinMapViewAction
import com.sailer.map.viewstate.DropPinMapViewEvent
import com.sailer.map.viewstate.DropPinMapViewState

/**
 * Created by Ahmed Abd-Elmeged on 6/10/20.
 */
class DropPinMapViewModel :
    BaseViewModel<DropPinMapViewState, DropPinMapViewEvent, DropPinMapViewAction>() {

    private var location: Location? = null

    override val initViewState: DropPinMapViewState = DropPinMapViewState.Init

    override fun postAction(action: DropPinMapViewAction) {
        when (action) {
            is DropPinMapViewAction.ClickOnBack -> sendCoordinatorEvent(MapCoordinatorEvent.Back)
            is DropPinMapViewAction.DropPinLocation -> location = action.location
            is DropPinMapViewAction.ConfirmDropPin -> handleConfirmDropPin()
        }.exhaustive
    }

    private fun handleConfirmDropPin() {
        if (location != null) {
            updateViewEvent(DropPinMapViewEvent.SetDropPinLocation(location!!))
            sendCoordinatorEvent(MapCoordinatorEvent.Back)
        } else {
            updateViewEvent(DropPinMapViewEvent.MissingLocation)
        }
    }
}