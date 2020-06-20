package com.sailer.shopping.presentation.product.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import com.sailer.core.base.view.BaseFragment
import com.sailer.core.extension.exhaustive
import com.sailer.core.extension.hostedViewModel
import com.sailer.core.extension.launchInternetSettingPanel
import com.sailer.core.extension.shortSnackbar
import com.sailer.shopping.R
import com.sailer.shopping.databinding.FragmentProductsBinding
import com.sailer.shopping.presentation.product.viewmodel.ProductsViewModel
import com.sailer.shopping.presentation.product.viewstate.ProductsViewAction
import com.sailer.shopping.presentation.product.viewstate.ProductsViewEvent
import com.sailer.shopping.presentation.product.viewstate.ProductsViewState

/**
 * Created by Ahmed Abd-Elmeged on 5/18/20.
 */
class ProductsFragment : BaseFragment<
        ProductsViewState,
        ProductsViewEvent,
        ProductsViewAction,
        ProductsViewModel,
        FragmentProductsBinding>() {

    override val viewModel: ProductsViewModel by hostedViewModel()

    override val theme: Int = R.style.AppTheme

    override fun onCreateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentProductsBinding {
        return FragmentProductsBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.backButton.postClickAction(ProductsViewAction.ClickOnBack)
        binding.searchButton.postClickAction(ProductsViewAction.ClickOnSearch)
    }


    override fun renderViewState(viewState: ProductsViewState) {
        binding.productsProgress.isVisible =
            viewState.productsResult is ProductsViewState.Result.Loading
    }

    override fun renderViewEvent(viewEvent: ProductsViewEvent) {
        when (viewEvent) {
            is ProductsViewEvent.NoInternet -> {
                launchInternetSettingPanel()
                shortSnackbar(binding.productsContainer, "Internet error")
            }
        }.exhaustive
    }
}