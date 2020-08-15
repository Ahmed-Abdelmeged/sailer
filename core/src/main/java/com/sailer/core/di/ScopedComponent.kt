package com.sailer.core.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner

/**
 * Inspired by https://proandroiddev.com/how-to-store-scoped-dagger-components-in-android-applications-4f3e86a5e957.
 * Created by Ahmed Abd-Elmeged on 5/6/20.
 */
@Suppress("UNCHECKED_CAST")
private class ScopedComponentProperty<T>(
    private val storeOwner: ViewModelStoreOwner,
    private val componentProvider: () -> T
) : Lazy<T> {

    private var cached: T? = null

    override val value: T
        get() {
            val component = cached
            if (component != null) return component
            val viewModels = ViewModelProvider(storeOwner, object : ViewModelProvider.Factory {
                override fun <VM : ViewModel> create(modelClass: Class<VM>): VM {
                    return ScopedComponentHolder(
                        componentProvider()
                    ) as VM
                }
            })
            val componentHolder = viewModels.get(ScopedComponentHolder::class.java)
            return (componentHolder.component as T).also { cached = it }
        }

    override fun isInitialized() = cached != null
}

fun <T> ViewModelStoreOwner.scopedComponent(
    componentProvider: () -> T
): Lazy<T> {
    return ScopedComponentProperty(this, componentProvider)
}

/**
 * Get the Activity component.
 */
@Suppress("UNCHECKED_CAST")
fun <T> Fragment.activityScopedComponent(): T {
    val viewModels = ViewModelProvider(requireActivity())
    val componentHolder = viewModels.get(ScopedComponentHolder::class.java)
    return componentHolder.component as T
}

private class ScopedComponentHolder<T> constructor(val component: T) : ViewModel()