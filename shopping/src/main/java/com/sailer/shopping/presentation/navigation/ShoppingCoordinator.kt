package com.sailer.shopping.presentation.navigation

import com.sailer.core.di.scopes.FeatureScope
import com.sailer.core.navigation.Coordinator
import com.sailer.core.navigation.FeatureNavigator
import com.sailer.core.navigation.GlobalCoordinatorEvent
import com.sailer.core.navigation.StartDestination
import com.sailer.shopping.R
import com.sailer.shopping.presentation.product.view.ProductsFragmentArgs
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject

/**
 * Created by Ahmed Abd-Elmeged on 5/5/20.
 */
@FeatureScope
class ShoppingCoordinator @AssistedInject constructor(
    featureNavigator: FeatureNavigator,
    @Assisted private val categoryId: Long
) : Coordinator(featureNavigator) {

    override fun onStart(): StartDestination {
        val args = ProductsFragmentArgs(categoryId = categoryId).toBundle()
        return StartDestination(R.id.productsFragment, args)
    }

    override fun onEvent(event: Any): Boolean {
        return when (event) {
            is GlobalCoordinatorEvent.Back -> navController?.popBackStack() == true

            is ShoppingCoordinatorEvent.Search -> search()

            is ShoppingCoordinatorEvent.Products -> products(
                categoryId = event.categoryId
            )

            else -> false
        }
    }

    private fun products(categoryId: Long): Boolean {
        val args = ProductsFragmentArgs(categoryId = categoryId).toBundle()
        navController?.navigate(R.id.productsFragment, args)
        return true
    }

    private fun search(): Boolean {
        navController?.navigate(R.id.searchFragment)
        return true
    }

    @AssistedInject.Factory
    interface Factory {
        fun create(categoryId: Long): ShoppingCoordinator
    }
}