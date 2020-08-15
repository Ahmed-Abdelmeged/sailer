package com.sailer.shopping.presentation.navigation

import com.sailer.core.navigation.CoordinatorEvent

/**
 * Created by Ahmed Abd-Elmeged on 6/15/20.
 */
sealed class ShoppingCoordinatorEvent : CoordinatorEvent {

    object Search : ShoppingCoordinatorEvent()

    data class Products(val categoryId: Long) : ShoppingCoordinatorEvent()
}