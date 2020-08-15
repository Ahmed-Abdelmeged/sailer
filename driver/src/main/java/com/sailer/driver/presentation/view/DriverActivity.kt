package com.sailer.driver.presentation.view

import android.view.LayoutInflater
import com.sailer.core.base.view.BaseActivity
import com.sailer.core.di.provideCoreComponent
import com.sailer.core.di.scopedComponent
import com.sailer.driver.R
import com.sailer.driver.databinding.ActivityDriverBinding
import com.sailer.driver.di.DaggerDriverComponent
import com.sailer.driver.di.DriverComponent
import com.sailer.driver.presentation.navigation.DriverCoordinator
import javax.inject.Inject

/**
 * Created by Ahmed Abd-Elmeged on 6/1/20.
 */
class DriverActivity : BaseActivity<ActivityDriverBinding, DriverCoordinator>() {

    private val component: DriverComponent by scopedComponent {
        DaggerDriverComponent
            .builder()
            .coreComponent(provideCoreComponent())
            .build()
    }

    @Inject
    lateinit var driverCoordinator: DriverCoordinator

    override val coordinator: DriverCoordinator get() = driverCoordinator

    override val theme: Int = R.style.AppTheme

    override val graph: Int = R.navigation.driver_nav_graph

    override val navHostId: Int = R.id.navHost

    override fun onPerformInjection() {
        component.inject(this)
    }

    override fun onCreateBinding(inflater: LayoutInflater): ActivityDriverBinding {
        return ActivityDriverBinding.inflate(inflater)
    }
}