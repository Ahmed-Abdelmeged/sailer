package com.sailer.driver.di

import com.sailer.core.di.CoreComponent
import com.sailer.core.di.scopes.AppScope
import com.sailer.driver.di.module.FragmentModule
import com.sailer.driver.presentation.navigation.DriverNavHostFragment
import com.sailer.driver.presentation.view.DriverActivity
import com.sailer.map.di.module.MapModule
import dagger.Component

/**
 * Created by Ahmed Abd-Elmeged on 6/1/20.
 */
@Component(
    modules = [FragmentModule::class, MapModule::class],
    dependencies = [CoreComponent::class]
)
@AppScope
interface DriverComponent {

    fun inject(activity: DriverActivity)

    fun inject(fragment: DriverNavHostFragment)
}