package com.sailer.shopping.presentation.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.sailer.core.base.view.BaseHostFragment
import com.sailer.core.viewstate.EmptyViewAction
import com.sailer.core.viewstate.EmptyViewEvent
import com.sailer.core.viewstate.EmptyViewState
import com.sailer.shopping.R
import com.sailer.shopping.databinding.FragmentShoppingHostBinding
import com.sailer.shopping.presentation.navigation.ShoppingCoordinator
import com.sailer.shopping.presentation.viewmodel.ShoppingHostViewModel
import javax.inject.Inject

/**
 * Created by Ahmed Abd-Elmeged on 5/6/20.
 */
class ShoppingHostFragment @Inject constructor(
    private val shoppingCoordinator: ShoppingCoordinator.Factory
) : BaseHostFragment<
        EmptyViewState,
        EmptyViewEvent,
        EmptyViewAction,
        ShoppingHostViewModel,
        FragmentShoppingHostBinding,
        ShoppingCoordinator>() {

    private val args: ShoppingHostFragmentArgs by navArgs()

    override val coordinator: ShoppingCoordinator by lazy {
        shoppingCoordinator.create(args.categoryId)
    }

    override val graph: Int = R.navigation.shopping_nav_graph

    override val navHostId: Int = R.id.navHost

    override val viewModel: ShoppingHostViewModel by viewModels()

    override val theme: Int = R.style.AppTheme

    override fun onCreateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentShoppingHostBinding {
        return FragmentShoppingHostBinding.inflate(inflater, container, false)
    }

    override fun renderViewState(viewState: EmptyViewState) {
    }

    override fun renderViewEvent(viewEvent: EmptyViewEvent) {
    }
}