package com.sailer.sailer.di

import android.content.Context
import com.sailer.auth.di.AuthComponent
import com.sailer.core.di.CoreComponent
import com.sailer.core.di.scopes.AppScope
import com.sailer.sailer.splash.view.SplashActivity
import dagger.BindsInstance
import dagger.Component

/**
 * Created by Ahmed Abd-Elmeged on 5/4/20.
 */
@AppScope
@Component(dependencies = [CoreComponent::class, AuthComponent::class])
interface AppComponent {

    fun inject(activity: SplashActivity)

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance applicationContext: Context,
            coreComponent: CoreComponent,
            authComponent: AuthComponent
        ): AppComponent
    }
}