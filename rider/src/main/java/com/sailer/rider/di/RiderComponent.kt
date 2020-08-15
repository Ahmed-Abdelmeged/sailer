package com.sailer.rider.di

import com.sailer.core.di.CoreComponent
import com.sailer.core.di.scopes.AppScope
import com.sailer.rider.di.module.FragmentModule
import com.sailer.rider.presentation.navigation.RiderNavHostFragment
import com.sailer.rider.presentation.view.RiderActivity
import com.sailer.shopping.di.module.ShoppingModule
import dagger.Component

/**
 * Created by Ahmed Abd-Elmeged on 6/1/20.
 */
@Component(
    modules = [FragmentModule::class, ShoppingModule::class],
    dependencies = [CoreComponent::class]
)
@AppScope
interface RiderComponent {

    fun inject(activity: RiderActivity)

    fun inject(fragment: RiderNavHostFragment)
}