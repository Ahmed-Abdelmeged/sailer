package com.sailer.core.di

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import javax.inject.Inject
import javax.inject.Provider

/**
 * Created by Ahmed Abd-Elmeged on 8/15/20.
 */
class FragmentInjectionFactory @Inject constructor(
    private val providers: Map<Class<out Fragment>, @JvmSuppressWildcards Provider<Fragment>>
) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        val fragmentClass = loadFragmentClass(classLoader, className)

        val provider = providers[fragmentClass]

        if (provider != null) {
            return provider.get()
        }

        return super.instantiate(classLoader, className)
    }
}