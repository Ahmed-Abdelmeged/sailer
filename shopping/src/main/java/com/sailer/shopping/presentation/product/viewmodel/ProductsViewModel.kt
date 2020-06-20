package com.sailer.shopping.presentation.product.viewmodel

import com.sailer.core.base.viewmodel.BaseViewModel
import com.sailer.core.extension.exhaustive
import com.sailer.shopping.domain.usecase.ProductsUseCase
import com.sailer.shopping.presentation.navigation.ShoppingCoordinatorEvent
import com.sailer.shopping.presentation.product.mapper.ProductUiMapper
import com.sailer.shopping.presentation.product.viewstate.ProductsViewAction
import com.sailer.shopping.presentation.product.viewstate.ProductsViewEvent
import com.sailer.shopping.presentation.product.viewstate.ProductsViewState

/**
 * Created by Ahmed Abd-Elmeged on 5/18/20.
 */
class ProductsViewModel(
    private val selectedCategoryId: Long,
    private val productsUseCase: ProductsUseCase,
    private val productMapper: ProductUiMapper
) : BaseViewModel<ProductsViewState, ProductsViewEvent, ProductsViewAction>() {

    override val initViewState: ProductsViewState = ProductsViewState(
        selectedCategoryPosition = 0,
        productsResult = ProductsViewState.Result.Loading
    ).also { updateViewState(it) }

    override fun postAction(action: ProductsViewAction) {
        when (action) {
            is ProductsViewAction.ClickOnBack -> sendCoordinatorEvent(ShoppingCoordinatorEvent.Back)
            is ProductsViewAction.ClickOnSearch -> sendCoordinatorEvent(ShoppingCoordinatorEvent.Search)
            is ProductsViewAction.TryAgain -> tryAgain()
        }.exhaustive
    }

    private fun tryAgain() {

    }

    override fun onCleared() {
        super.onCleared()
        productsUseCase.dispose()
    }
}