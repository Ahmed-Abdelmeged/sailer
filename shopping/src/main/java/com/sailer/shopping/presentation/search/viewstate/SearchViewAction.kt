package com.sailer.shopping.presentation.search.viewstate

import com.sailer.core.viewstate.ViewAction

/**
 * Created by Ahmed Abd-Elmeged on 5/27/20.
 */
sealed class SearchViewAction : ViewAction {

    object ClickOnBack : SearchViewAction()
}