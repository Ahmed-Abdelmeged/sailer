package com.sailer.core.di.module

import com.sailer.core.navigation.FeatureNavigator
import com.sailer.core.navigation.FeatureNavigatorImpl
import dagger.Binds
import dagger.Module

/**
 * Created by Ahmed Abd-Elmeged on 5/6/20.
 */
@Module
abstract class NavigationModule {

    @Binds
    abstract fun bindFeatureNavigator(featureNavigator: FeatureNavigatorImpl): FeatureNavigator
}