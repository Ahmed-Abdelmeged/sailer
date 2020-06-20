package com.sailer.map.viewstate

import com.sailer.core.viewstate.ViewState

/**
 * Created by Ahmed Abd-Elmeged on 6/10/20.
 */
sealed class DropPinMapViewState : ViewState {
    object Init : DropPinMapViewState()
}