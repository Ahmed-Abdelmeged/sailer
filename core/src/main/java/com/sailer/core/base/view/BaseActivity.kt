package com.sailer.core.base.view

import android.os.Bundle
import android.view.LayoutInflater
import androidx.annotation.IdRes
import androidx.annotation.NavigationRes
import androidx.annotation.StyleRes
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

    @get:StyleRes
    protected abstract val theme: Int

    @get:NavigationRes
    abstract val graph: Int

    @get:IdRes
    abstract val navHostId: Int

    abstract fun onPerformInjection()

    abstract fun onCreateBinding(inflater: LayoutInflater): VB

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(theme)
        onPerformInjection()

        super.onCreate(savedInstanceState)

        binding = onCreateBinding(layoutInflater)
        setContentView(binding.root)

        coordinator.navController = findNavController(navHostId)
        coordinator.activity = this

        val host = supportFragmentManager.findFragmentById(navHostId) as NavHostFragment
        coordinator.navHostFragment = host

        setupNavigationGraph(graphId = graph, host = host, startDestination = coordinator.onStart())
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
        coordinator.clear()
    }
}