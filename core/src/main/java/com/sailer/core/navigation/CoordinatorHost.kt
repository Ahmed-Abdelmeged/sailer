package com.sailer.core.navigation

/**
 * Created by Ahmed Abd-Elmeged on 5/6/20.
 */
interface CoordinatorHost<C : Coordinator> {

    val coordinator: C
}