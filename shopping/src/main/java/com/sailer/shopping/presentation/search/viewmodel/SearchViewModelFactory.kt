package com.sailer.shopping.presentation.search.viewmodel

import com.sailer.core.base.viewmodel.BaseViewModelFactory
import com.squareup.inject.assisted.AssistedInject

/**
 * Created by Ahmed Abd-Elmeged on 5/27/20.
 */
class SearchViewModelFactory @AssistedInject constructor() :
    BaseViewModelFactory<SearchViewModel>() {

    override fun createViewModel(): SearchViewModel {
        return SearchViewModel()
    }

    @AssistedInject.Factory
    interface Factory {
        fun create(): SearchViewModelFactory
    }
}