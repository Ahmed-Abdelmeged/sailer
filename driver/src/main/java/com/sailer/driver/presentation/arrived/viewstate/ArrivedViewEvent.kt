package com.sailer.driver.presentation.arrived.viewstate

import com.sailer.core.viewstate.ViewEvent

/**
 * Created by Ahmed Abd-Elmeged on 6/5/20.
 */
sealed class ArrivedViewEvent : ViewEvent {

    object MissingDropPinLocation : ArrivedViewEvent()
}