package com.sailer.shopping.presentation.search.viewstate

import com.sailer.core.viewstate.ViewEvent

/**
 * Created by Ahmed Abd-Elmeged on 5/27/20.
 */
sealed class SearchViewEvent : ViewEvent {

    data class SearchError(val error: String) : SearchViewEvent()

    object NoInternet : SearchViewEvent()
}