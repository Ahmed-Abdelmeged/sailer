package com.sailer.shopping.di

import com.sailer.core.di.CoreComponent
import com.sailer.core.di.scopes.FeatureScope
import com.sailer.shopping.di.module.ViewModelModule
import com.sailer.shopping.presentation.view.ShoppingActivity
import dagger.Component

/**
 * Created by Ahmed Abd-Elmeged on 5/5/20.
 */
@Component(
    modules = [ViewModelModule::class],
    dependencies = [CoreComponent::class]
)
@FeatureScope
interface ShoppingComponent {

    fun inject(activity: ShoppingActivity)
}