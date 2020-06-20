package com.sailer.shopping.presentation.navigation

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.sailer.core.di.scopes.FeatureScope
import com.sailer.core.navigation.Coordinator
import com.sailer.core.navigation.Displayable
import com.sailer.core.navigation.FeatureNavigator
import com.sailer.core.navigation.StartDestination
import com.sailer.shopping.R
import com.sailer.shopping.presentation.product.view.ProductsFragment
import com.sailer.shopping.presentation.product.view.ProductsFragmentArgs
import com.sailer.shopping.presentation.product.viewmodel.ProductsViewModelFactory
import com.sailer.shopping.presentation.search.view.SearchFragment
import com.sailer.shopping.presentation.search.viewmodel.SearchViewModelFactory
import dagger.Lazy
import javax.inject.Inject

/**
 * Created by Ahmed Abd-Elmeged on 5/5/20.
 */
@FeatureScope
class ShoppingCoordinator @Inject constructor(
    featureNavigator: FeatureNavigator,
    private val productsViewModelFactory: Lazy<ProductsViewModelFactory.Factory>,
    private val searchViewModelFactory: Lazy<SearchViewModelFactory.Factory>
) : Coordinator(featureNavigator) {

    fun start(categoryId: Long): StartDestination {
        val args = ProductsFragmentArgs(categoryId = categoryId).toBundle()
        return StartDestination(R.id.productsFragment, args)
    }

    override fun onCreateViewModelFactory(screen: Displayable): ViewModelProvider.Factory {
        return when (screen) {
            is ProductsFragment -> {
                val args = screen.navArgs<ProductsFragmentArgs>().value
                productsViewModelFactory.get().create(
                    categoryId = args.categoryId
                )
            }

            is SearchFragment -> searchViewModelFactory.get().create()

            else -> throw IllegalArgumentException("Not supported fragment for the current coordinator")
        }
    }

    override fun onEvent(event: Any) {
        when (event) {
            is ShoppingCoordinatorEvent.Back -> back()

            is ShoppingCoordinatorEvent.Search -> search()

            is ShoppingCoordinatorEvent.Products -> products(
                categoryId = event.categoryId
            )
        }
    }

    private fun products(categoryId: Long) {
        val args = ProductsFragmentArgs(categoryId = categoryId).toBundle()
        navController?.navigate(R.id.productsFragment, args)
    }

    private fun search() {
        navController?.navigate(R.id.searchFragment)
    }
}