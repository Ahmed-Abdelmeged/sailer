package com.sailer.shopping.di.module

import androidx.fragment.app.Fragment
import com.sailer.core.di.FragmentKey
import com.sailer.shopping.presentation.view.ShoppingHostFragment
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
    @FragmentKey(ShoppingHostFragment::class)
    abstract fun shoppingHostFragment(fragment: ShoppingHostFragment): Fragment
}