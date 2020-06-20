package com.sailer.sailer.splash.view

import android.os.Bundle
import android.view.LayoutInflater
import com.sailer.auth.di.DaggerAuthComponent
import com.sailer.core.base.view.BaseActivity
import com.sailer.core.di.provideCoreComponent
import com.sailer.core.di.scopedComponent
import com.sailer.core.navigation.StartDestination
import com.sailer.sailer.databinding.ActivitySplashBinding
import com.sailer.sailer.di.AppComponent
import com.sailer.sailer.di.DaggerAppComponent
import com.sailer.sailer.navigation.AppCoordinator
import com.sailer.sailer.navigation.AppCoordinatorEvent
import javax.inject.Inject

class SplashActivity : BaseActivity<ActivitySplashBinding, AppCoordinator>() {

    private val component: AppComponent by scopedComponent {
        val authComponent = DaggerAuthComponent.builder()
            .coreComponent(provideCoreComponent())
            .build()
        DaggerAppComponent.factory().create(this, provideCoreComponent(), authComponent)
    }

    @Inject
    lateinit var appCoordinator: AppCoordinator

    override val coordinator: AppCoordinator get() = appCoordinator

    override val graph: Int
        get() = TODO("Not yet implemented")
    override val navHostId: Int
        get() = TODO("Not yet implemented")

    override val hostView: Boolean = false

    override fun onPerformInjection() {
        component.inject(this)
    }

    override fun onCreateBinding(inflater: LayoutInflater): ActivitySplashBinding {
        return ActivitySplashBinding.inflate(inflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        coordinator.onEvent(AppCoordinatorEvent.Start)
    }

    override fun onStartDestination(): StartDestination {
        TODO("Not yet implemented")
    }
}