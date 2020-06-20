package com.sailer.rider.presentation.home.viewstate

import com.sailer.core.viewstate.ViewAction

/**
 * Created by Ahmed Abd-Elmeged on 6/5/20.
 */
sealed class HomeViewAction : ViewAction {

    object ClickOnBack : HomeViewAction()

    object OpenShopping : HomeViewAction()
}