package com.sailer.map.di.module

import androidx.fragment.app.Fragment
import com.sailer.core.di.FragmentKey
import com.sailer.map.view.DropPinMapFragment
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * Created by Ahmed Abd-Elmeged on 8/15/20.
 */
@Module
abstract class MapModule {

    @Binds
    @IntoMap
    @FragmentKey(DropPinMapFragment::class)
    abstract fun dropPinMapFragment(fragment: DropPinMapFragment): Fragment
}