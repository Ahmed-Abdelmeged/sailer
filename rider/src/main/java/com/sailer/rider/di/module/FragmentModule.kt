package com.sailer.rider.di.module

import androidx.fragment.app.Fragment
import com.sailer.core.di.FragmentKey
import com.sailer.rider.presentation.home.view.HomeFragment
import com.sailer.shopping.presentation.product.view.ProductsFragment
import com.sailer.shopping.presentation.search.view.SearchFragment
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
    @FragmentKey(HomeFragment::class)
    abstract fun homeFragment(fragment: HomeFragment): Fragment

    @Binds
    @IntoMap
    @FragmentKey(ProductsFragment::class)
    abstract fun productsFragment(fragment: ProductsFragment): Fragment

    @Binds
    @IntoMap
    @FragmentKey(SearchFragment::class)
    abstract fun searchFragment(fragment: SearchFragment): Fragment
}