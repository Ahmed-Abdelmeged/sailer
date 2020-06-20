package com.sailer.shopping.presentation.search.viewmodel

import com.sailer.core.base.viewmodel.BaseViewModel
import com.sailer.core.extension.exhaustive
import com.sailer.shopping.presentation.navigation.ShoppingCoordinatorEvent
import com.sailer.shopping.presentation.search.viewstate.SearchViewAction
import com.sailer.shopping.presentation.search.viewstate.SearchViewEvent
import com.sailer.shopping.presentation.search.viewstate.SearchViewState

/**
 * Created by Ahmed Abd-Elmeged on 5/27/20.
 */
class SearchViewModel : BaseViewModel<SearchViewState, SearchViewEvent, SearchViewAction>() {

    override val initViewState: SearchViewState = SearchViewState().also { updateViewState(it) }

    override fun postAction(action: SearchViewAction) {
        when (action) {
            is SearchViewAction.ClickOnBack -> sendCoordinatorEvent(ShoppingCoordinatorEvent.Back)
        }.exhaustive
    }
}