package com.sailer.core.event

import androidx.lifecycle.Observer

/**
 * Same as [EventObserver] but support nullable types.
 * Created by Ahmed Abd-Elmeged on 5/1/20.
 */
class NullableEventObserver<T>(private val onEventUnhandledContent: (T?) -> Unit) :
    Observer<Event<T?>> {
    override fun onChanged(event: Event<T?>?) {
        event?.let { it ->
            if (!it.hasBeenHandled) {
                onEventUnhandledContent.invoke(it.getContentIfNotHandled())
            }
        }
    }
}