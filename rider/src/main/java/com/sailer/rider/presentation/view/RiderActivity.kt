package com.sailer.rider.presentation.view

import android.view.LayoutInflater
import com.sailer.core.base.view.BaseActivity
import com.sailer.core.di.provideCoreComponent
import com.sailer.core.di.scopedComponent
import com.sailer.core.navigation.StartDestination
import com.sailer.rider.R
import com.sailer.rider.databinding.ActivityRiderBinding
import com.sailer.rider.di.DaggerRiderComponent
import com.sailer.rider.di.RiderComponent
import com.sailer.rider.presentation.navigation.RiderCoordinator
import javax.inject.Inject

/**
 * Created by Ahmed Abd-Elmeged on 6/1/20.
 */
class RiderActivity : BaseActivity<ActivityRiderBinding, RiderCoordinator>() {

    private val component: RiderComponent by scopedComponent {
        DaggerRiderComponent
            .builder()
            .coreComponent(provideCoreComponent())
            .build()
    }

    @Inject
    lateinit var riderCoordinator: RiderCoordinator

    override val coordinator: RiderCoordinator get() = riderCoordinator

    override val graph: Int = R.navigation.rider_nav_graph

    override val navHostId: Int = R.id.navHost

    override fun onPerformInjection() {
        component.inject(this)
    }

    override fun onCreateBinding(inflater: LayoutInflater): ActivityRiderBinding {
        return ActivityRiderBinding.inflate(inflater)
    }

    override fun onStartDestination(): StartDestination {
        return coordinator.start()
    }
}