package com.sailer.shopping.presentation.viewmodel

import com.sailer.core.base.viewmodel.BaseViewModel
import com.sailer.core.viewstate.EmptyViewAction
import com.sailer.core.viewstate.EmptyViewEvent
import com.sailer.core.viewstate.EmptyViewState

/**
 * Created by Ahmed Abd-Elmeged on 8/15/20.
 */
class ShoppingHostViewModel : BaseViewModel<EmptyViewState, EmptyViewEvent, EmptyViewAction>() {

    override val initViewState: EmptyViewState
        get() = throw NotImplementedError()

    override fun postAction(action: EmptyViewAction) {
        throw NotImplementedError()
    }
}