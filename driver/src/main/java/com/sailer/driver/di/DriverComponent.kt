package com.sailer.driver.di

import com.sailer.core.di.CoreComponent
import com.sailer.core.di.scopes.AppScope
import com.sailer.driver.di.module.ViewModelModule
import com.sailer.driver.presentation.view.DriverActivity
import com.sailer.map.di.module.MapViewModelModule
import dagger.Component

/**
 * Created by Ahmed Abd-Elmeged on 6/1/20.
 */
@Component(
    modules = [ViewModelModule::class, MapViewModelModule::class],
    dependencies = [CoreComponent::class]
)
@AppScope
interface DriverComponent {

    fun inject(activity: DriverActivity)
}