package com.sailer.map.viewmodel

import com.sailer.core.base.viewmodel.BaseViewModelFactory
import com.squareup.inject.assisted.AssistedInject

/**
 * Created by Ahmed Abd-Elmeged on 6/10/20.
 */
class DropPinMapViewModelFactory @AssistedInject constructor() :
    BaseViewModelFactory<DropPinMapViewModel>() {

    override fun createViewModel(): DropPinMapViewModel {
        return DropPinMapViewModel()
    }


    @AssistedInject.Factory
    interface Factory {
        fun create(): DropPinMapViewModelFactory
    }
}