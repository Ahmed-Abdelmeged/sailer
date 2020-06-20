package com.sailer.rider.di

import com.sailer.core.di.CoreComponent
import com.sailer.core.di.scopes.AppScope
import com.sailer.rider.di.module.ViewModelModule
import com.sailer.rider.presentation.view.RiderActivity
import dagger.Component

/**
 * Created by Ahmed Abd-Elmeged on 6/1/20.
 */
@Component(
    modules = [ViewModelModule::class],
    dependencies = [CoreComponent::class]
)
@AppScope
interface RiderComponent {

    fun inject(activity: RiderActivity)
}