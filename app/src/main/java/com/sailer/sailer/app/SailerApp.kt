package com.sailer.sailer.app

import android.app.Application
import com.sailer.auth.di.DaggerAuthComponent
import com.sailer.core.di.CoreComponent
import com.sailer.core.di.CoreComponentProvider
import com.sailer.core.di.DaggerCoreComponent
import com.sailer.sailer.BuildConfig
import com.sailer.sailer.di.AppComponent
import com.sailer.sailer.di.DaggerAppComponent
import timber.log.Timber

/**
 * Created by Ahmed Abd-Elmeged on 4/20/20.
 */
class SailerApp : Application(), CoreComponentProvider {

    private val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.factory().create(this)
    }

    val appComponent: AppComponent by lazy {
        val authComponent = DaggerAuthComponent.factory()
            .create(coreComponent = provideCoreComponent())

        DaggerAppComponent.factory()
            .create(coreComponent = coreComponent, authComponent = authComponent)
    }

    override fun onCreate() {
        super.onCreate()
        appComponent.inject(this)

        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }

    override fun provideCoreComponent(): CoreComponent {
        return coreComponent
    }
}