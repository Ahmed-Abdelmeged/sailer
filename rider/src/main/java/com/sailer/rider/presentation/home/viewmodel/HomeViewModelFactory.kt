package com.sailer.rider.presentation.home.viewmodel

import com.sailer.core.base.viewmodel.BaseViewModelFactory

import com.squareup.inject.assisted.AssistedInject

/**
 * Created by Ahmed Abd-Elmeged on 6/5/20.
 */
class HomeViewModelFactory @AssistedInject constructor() :
    BaseViewModelFactory<HomeViewModel>() {

    override fun createViewModel(): HomeViewModel {
        return HomeViewModel()
    }

    @AssistedInject.Factory
    interface Factory {
        fun create(): HomeViewModelFactory
    }
}