package com.sailer.driver.presentation.arrived.viewmodel

import com.sailer.core.base.viewmodel.BaseViewModel
import com.sailer.core.extension.exhaustive
import com.sailer.driver.presentation.arrived.viewstate.ArrivedViewAction
import com.sailer.driver.presentation.arrived.viewstate.ArrivedViewEvent
import com.sailer.driver.presentation.arrived.viewstate.ArrivedViewState
import com.sailer.driver.presentation.navigation.DriverCoordinatorEvent
import com.sailer.map.model.Location

/**
 * Created by Ahmed Abd-Elmeged on 6/5/20.
 */
class ArrivedViewModel : BaseViewModel<ArrivedViewState, ArrivedViewEvent, ArrivedViewAction>() {

    private var dropPinLocation: Location? = null

    override val initViewState: ArrivedViewState = ArrivedViewState().also { updateViewState(it) }

    override fun postAction(action: ArrivedViewAction) {
        when (action) {
            is ArrivedViewAction.ClickOnBack -> sendCoordinatorEvent(DriverCoordinatorEvent.Back)
            is ArrivedViewAction.OpenMap -> sendCoordinatorEvent(DriverCoordinatorEvent.Map)
            is ArrivedViewAction.DropPinLocation -> dropPinLocation = action.location
        }.exhaustive
    }
}