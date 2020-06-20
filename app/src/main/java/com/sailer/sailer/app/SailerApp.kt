package com.sailer.sailer.app

import android.app.Application
import android.os.StrictMode
import com.sailer.core.di.CoreComponent
import com.sailer.core.di.CoreComponentProvider
import com.sailer.core.di.DaggerCoreComponent
import com.sailer.sailer.BuildConfig
import timber.log.Timber

/**
 * Created by Ahmed Abd-Elmeged on 4/20/20.
 */
class SailerApp : Application(), CoreComponentProvider {

    private val coreComponent: CoreComponent by lazy {
        DaggerCoreComponent.factory().create(this)
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())

            setupStrictMode()
        }
    }

    private fun setupStrictMode() {
        StrictMode.setThreadPolicy(
            StrictMode.ThreadPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .build()
        )

        StrictMode.setVmPolicy(
            StrictMode.VmPolicy.Builder()
                .detectAll()
                .penaltyLog()
                .build()
        )
    }

    override fun provideCoreComponent(): CoreComponent {
        return coreComponent
    }
}