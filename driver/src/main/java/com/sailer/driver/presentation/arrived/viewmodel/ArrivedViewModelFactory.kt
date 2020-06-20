package com.sailer.driver.presentation.arrived.viewmodel

import com.sailer.core.base.viewmodel.BaseViewModelFactory

import com.squareup.inject.assisted.AssistedInject

/**
 * Created by Ahmed Abd-Elmeged on 6/5/20.
 */
class ArrivedViewModelFactory @AssistedInject constructor() :
    BaseViewModelFactory<ArrivedViewModel>() {

    override fun createViewModel(): ArrivedViewModel {
        return ArrivedViewModel()
    }

    @AssistedInject.Factory
    interface Factory {
        fun create(): ArrivedViewModelFactory
    }
}