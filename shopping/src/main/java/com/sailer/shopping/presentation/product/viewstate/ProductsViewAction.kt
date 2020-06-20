package com.sailer.shopping.presentation.product.viewstate

import com.sailer.core.viewstate.ViewAction

/**
 * Created by Ahmed Abd-Elmeged on 5/18/20.
 */
sealed class ProductsViewAction : ViewAction {

    object ClickOnBack : ProductsViewAction()

    object ClickOnSearch : ProductsViewAction()

    object TryAgain : ProductsViewAction()
}