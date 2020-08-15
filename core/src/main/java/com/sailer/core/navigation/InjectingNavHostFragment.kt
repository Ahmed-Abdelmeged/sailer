package com.sailer.core.navigation

import android.content.Context
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.sailer.core.di.FragmentInjectionFactory
import javax.inject.Inject

/**
 * Created by Ahmed Abd-Elmeged on 7/23/20.
 */
abstract class InjectingNavHostFragment : NavHostFragment() {

    @Inject
    lateinit var fragmentFactory: FragmentInjectionFactory

    abstract fun onPerformInjection()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        onPerformInjection()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        childFragmentManager.fragmentFactory = fragmentFactory
        super.onCreate(savedInstanceState)
    }
}