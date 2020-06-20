package com.sailer.core.base.view

import android.os.Bundle
import android.view.LayoutInflater
import androidx.annotation.IdRes
import androidx.annotation.NavigationRes
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.viewbinding.ViewBinding
import com.sailer.core.navigation.Coordinator
import com.sailer.core.navigation.CoordinatorHost
import com.sailer.core.navigation.StartDestination

/**
 * Created by Ahmed Abd-Elmeged on 5/6/20.
 */
abstract class BaseActivity<VB : ViewBinding, C : Coordinator> : AppCompatActivity(),
    CoordinatorHost<C> {

    lateinit var binding: VB
        private set

    @get:NavigationRes
    abstract val graph: Int

    @get:IdRes
    abstract val navHostId: Int

    abstract fun onPerformInjection()

    abstract fun onCreateBinding(inflater: LayoutInflater): VB

    abstract fun onStartDestination(): StartDestination

    protected open val hostView = true

    override fun onCreate(savedInstanceState: Bundle?) {
        onPerformInjection()
        super.onCreate(savedInstanceState)
        binding = onCreateBinding(layoutInflater)
        setContentView(binding.root)

        coordinator.activity = this
        if (hostView) {
            coordinator.navController = findNavController(navHostId)

            setupNavigationGraph(
                graphId = graph,
                host = supportFragmentManager.findFragmentById(navHostId) as NavHostFragment,
                startDestination = onStartDestination()
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

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(navHostId).navigateUp()
    }

    override fun onDestroy() {
        super.onDestroy()
        coordinator.activity = null
        coordinator.navController = null
    }
}