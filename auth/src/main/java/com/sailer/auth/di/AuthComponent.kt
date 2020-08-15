package com.sailer.auth.di

import com.sailer.auth.domain.usecase.GetLoginStatusUseCase
import com.sailer.core.di.CoreComponent
import com.sailer.core.di.scopes.FeatureScope
import dagger.Component

/**
 * Created by Ahmed Abd-Elmeged on 4/22/20.
 */
@Component(dependencies = [CoreComponent::class])
@FeatureScope
interface AuthComponent {

    fun provideGetLoginStatusUseCase(): GetLoginStatusUseCase

    @Component.Factory
    interface Factory {
        fun create(coreComponent: CoreComponent): AuthComponent
    }
}