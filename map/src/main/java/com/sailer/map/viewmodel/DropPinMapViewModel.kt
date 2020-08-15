package com.sailer.map.viewmodel

import com.sailer.core.base.viewmodel.BaseViewModel
import com.sailer.core.extension.exhaustive
import com.sailer.core.navigation.GlobalCoordinatorEvent
import com.sailer.map.model.Location
import com.sailer.map.viewstate.DropPinMapViewAction
import com.sailer.map.viewstate.DropPinMapViewEvent
import com.sailer.map.viewstate.DropPinMapViewState
import javax.inject.Inject

/**
 * Created by Ahmed Abd-Elmeged on 6/10/20.
 */
class DropPinMapViewModel @Inject constructor() :
    BaseViewModel<DropPinMapViewState, DropPinMapViewEvent, DropPinMapViewAction>() {

    private var location: Location? = null

    override val initViewState: DropPinMapViewState = DropPinMapViewState.Init

    override fun postAction(action: DropPinMapViewAction) {
        when (action) {
            is DropPinMapViewAction.ClickOnBack -> sendCoordinatorEvent(GlobalCoordinatorEvent.Back)
            is DropPinMapViewAction.DropPinLocation -> location = action.location
            is DropPinMapViewAction.ConfirmDropPin -> handleConfirmDropPin()
        }.exhaustive
    }

    private fun handleConfirmDropPin() {
        if (location != null) {
            updateViewEvent(DropPinMapViewEvent.SetDropPinLocation(location!!))
            sendCoordinatorEvent(GlobalCoordinatorEvent.Back)
        } else {
            updateViewEvent(DropPinMapViewEvent.MissingLocation)
        }
    }
}