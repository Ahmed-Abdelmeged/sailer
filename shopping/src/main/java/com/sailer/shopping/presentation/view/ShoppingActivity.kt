package com.sailer.shopping.presentation.view

import android.view.LayoutInflater
import com.sailer.actions.args.CategoryArgs
import com.sailer.core.base.view.BaseActivity
import com.sailer.core.di.provideCoreComponent
import com.sailer.core.di.scopedComponent
import com.sailer.core.navigation.StartDestination
import com.sailer.shopping.R
import com.sailer.shopping.databinding.ActivityShoppingBinding
import com.sailer.shopping.di.DaggerShoppingComponent
import com.sailer.shopping.di.ShoppingComponent
import com.sailer.shopping.presentation.navigation.ShoppingCoordinator
import javax.inject.Inject

/**
 * Created by Ahmed Abd-Elmeged on 5/6/20.
 */
class ShoppingActivity : BaseActivity<ActivityShoppingBinding, ShoppingCoordinator>() {

    private val component: ShoppingComponent by scopedComponent {
        DaggerShoppingComponent
            .builder()
            .coreComponent(provideCoreComponent())
            .build()
    }

    @Inject
    lateinit var shoppingCoordinator: ShoppingCoordinator

    override val coordinator: ShoppingCoordinator get() = shoppingCoordinator

    override val graph: Int = R.navigation.shopping_nav_graph

    override val navHostId: Int = R.id.navHost

    override fun onPerformInjection() {
        component.inject(this)
    }

    override fun onCreateBinding(inflater: LayoutInflater): ActivityShoppingBinding {
        return ActivityShoppingBinding.inflate(inflater)
    }

    override fun onStartDestination(): StartDestination {
        val categoryId = intent.getParcelableExtra<CategoryArgs>(CategoryArgs.KEY)?.categoryId ?: 0
        return coordinator.start(categoryId)
    }
}