package com.sailer.rider.presentation.home.viewmodel

import com.sailer.core.base.viewmodel.BaseViewModel
import com.sailer.core.extension.exhaustive
import com.sailer.core.navigation.GlobalCoordinatorEvent
import com.sailer.rider.presentation.home.viewstate.HomeViewAction
import com.sailer.rider.presentation.home.viewstate.HomeViewEvent
import com.sailer.rider.presentation.home.viewstate.HomeViewState
import com.sailer.rider.presentation.navigation.RiderCoordinatorEvent
import javax.inject.Inject

/**
 * Created by Ahmed Abd-Elmeged on 6/5/20.
 */
class HomeViewModel @Inject constructor() :
    BaseViewModel<HomeViewState, HomeViewEvent, HomeViewAction>() {

    override val initViewState: HomeViewState = HomeViewState().also { updateViewState(it) }

    override fun postAction(action: HomeViewAction) {
        when (action) {
            is HomeViewAction.ClickOnBack -> sendCoordinatorEvent(GlobalCoordinatorEvent.Back)
            is HomeViewAction.OpenShopping -> sendCoordinatorEvent(RiderCoordinatorEvent.Shopping)
        }.exhaustive
    }
}