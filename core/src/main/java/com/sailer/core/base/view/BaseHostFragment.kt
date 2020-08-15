package com.sailer.core.base.view

import android.os.Bundle
import android.view.View
import androidx.annotation.IdRes
import androidx.annotation.NavigationRes
import androidx.navigation.fragment.NavHostFragment
import androidx.viewbinding.ViewBinding
import com.sailer.core.base.viewmodel.BaseViewModel
import com.sailer.core.navigation.Coordinator
import com.sailer.core.navigation.CoordinatorHost
import com.sailer.core.navigation.StartDestination
import com.sailer.core.viewstate.ViewAction
import com.sailer.core.viewstate.ViewEvent
import com.sailer.core.viewstate.ViewState

/**
 * To support child coordinators/flows in a single activity setup.
 * Created by Ahmed Abd-Elmeged on 6/29/20.
 */
abstract class BaseHostFragment<VS : ViewState,
        VE : ViewEvent,
        VA : ViewAction,
        VM : BaseViewModel<VS, VE, VA>,
        VB : ViewBinding,
        C : Coordinator
        > : BaseFragment<VS, VE, VA, VM, VB>(), CoordinatorHost<C> {

    @get:NavigationRes
    abstract val graph: Int

    @get:IdRes
    abstract val navHostId: Int

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        coordinator.activity = requireActivity()

        val host = childFragmentManager.findFragmentById(navHostId) as NavHostFragment
        coordinator.navController = host.navController
        coordinator.navHostFragment = host

        if (coordinator.navController?.currentDestination == null) {
            setupNavigationGraph(
                graphId = graph,
                host = host,
                startDestination = coordinator.onStart()
            )
        }
    }

    private fun setupNavigationGraph(
        @NavigationRes graphId: Int,
        host: NavHostFragment,
        startDestination: StartDestination
    ) {
        val inflater = host.navController.navInflater
        val graph = inflater.inflate(graphId)
        graph.startDestination = startDestination.destination
        host.navController.setGraph(graph, startDestination.args)
    }

    override fun onDestroy() {
        super.onDestroy()
        coordinator.clear()
    }
}