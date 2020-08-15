package com.sailer.driver.di.module

import androidx.fragment.app.Fragment
import com.sailer.core.di.FragmentKey
import com.sailer.driver.presentation.arrived.view.ArrivedFragment
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Ahmed Abd-Elmeged on 8/15/20.
 */
@Module
abstract class FragmentModule {

    @Binds
    @IntoMap
    @FragmentKey(ArrivedFragment::class)
    abstract fun arrivedFragment(fragment: ArrivedFragment): Fragment
}