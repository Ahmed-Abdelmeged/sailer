package com.sailer.shopping.presentation.product.viewstate

import com.sailer.core.viewstate.ViewState

/**
 * Created by Ahmed Abd-Elmeged on 5/18/20.
 */
data class ProductsViewState(
    val selectedCategoryPosition: Int,
    val productsResult: Result
) : ViewState {
    sealed class Result {
        object Loading : Result()

        data class Success(
            val empty: Boolean
        ) : Result()

        object Error : Result()

        object NoInternet : Result()
    }
}