package com.sailer.core.di

import android.content.Context
import com.sailer.core.di.module.NavigationModule
import com.sailer.core.navigation.FeatureNavigator
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Ahmed Abd-Elmeged on 4/25/20.
 */
@Singleton
@Component(modules = [NavigationModule::class])
interface CoreComponent {

    fun providerContext(): Context

    fun providerFeatureNavigator(): FeatureNavigator

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance applicationContext: Context
        ): CoreComponent
    }
}