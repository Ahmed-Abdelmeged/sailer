package com.sailer.core.base.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.sailer.core.event.Event
import com.sailer.core.extension.asLiveData
import com.sailer.core.navigation.CoordinatorEvent
import com.sailer.core.viewstate.ViewAction
import com.sailer.core.viewstate.ViewEvent
import com.sailer.core.viewstate.ViewState

/**
 * Created by Ahmed Abd-Elmeged on 4/22/20.
 */
abstract class BaseViewModel<VS : ViewState, VE : ViewEvent, VA : ViewAction> : ViewModel() {

    abstract val initViewState: VS

    private val _viewState = MutableLiveData<VS>()
    val viewState = _viewState.asLiveData()

    private val _viewEvent = MutableLiveData<Event<VE>>()
    val viewEvent = _viewEvent.asLiveData()

    private val _coordinatorEvent = MutableLiveData<Event<CoordinatorEvent>>()
    val coordinatorEvent = _coordinatorEvent.asLiveData()

    abstract fun postAction(action: VA)

    fun currentViewState(): VS {
        return viewState.value ?: initViewState
    }

    protected fun updateViewState(state: VS) {
        _viewState.value = state
    }

    protected fun updateViewEvent(event: VE) {
        _viewEvent.value = Event(event)
    }

    protected fun <E : CoordinatorEvent> sendCoordinatorEvent(event: E) {
        _coordinatorEvent.value = Event(event)
    }
}