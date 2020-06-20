package com.sailer.shopping.presentation.product.viewstate

import com.sailer.core.viewstate.ViewEvent

/**
 * Created by Ahmed Abd-Elmeged on 5/18/20.
 */
sealed class ProductsViewEvent : ViewEvent {
    object NoInternet : ProductsViewEvent()
}