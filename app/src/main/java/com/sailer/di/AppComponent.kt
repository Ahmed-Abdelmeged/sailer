package com.sailer.di

import com.sailer.auth.di.AuthComponent
import com.sailer.core.di.CoreComponent
import com.sailer.core.di.scopes.AppScope
import com.sailer.app.SailerApp
import com.sailer.splash.view.SplashActivity
import dagger.Component

/**
 * Created by Ahmed Abd-Elmeged on 5/4/20.
 */
@AppScope
@Component(dependencies = [CoreComponent::class, AuthComponent::class])
interface AppComponent {

    fun inject(app: SailerApp)

    fun inject(activity: SplashActivity)

    @Component.Factory
    interface Factory {
        fun create(
            coreComponent: CoreComponent,
            authComponent: AuthComponent
        ): AppComponent
    }
}