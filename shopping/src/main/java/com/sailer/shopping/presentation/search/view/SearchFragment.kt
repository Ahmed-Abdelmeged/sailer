package com.sailer.shopping.presentation.search.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sailer.core.base.view.BaseFragment
import com.sailer.core.extension.viewModelWithProvider
import com.sailer.shopping.R
import com.sailer.shopping.databinding.FragmentSearchBinding
import com.sailer.shopping.presentation.search.viewmodel.SearchViewModel
import com.sailer.shopping.presentation.search.viewstate.SearchViewAction
import com.sailer.shopping.presentation.search.viewstate.SearchViewEvent
import com.sailer.shopping.presentation.search.viewstate.SearchViewState
import javax.inject.Inject
import javax.inject.Provider

/**
 * Created by Ahmed Abd-Elmeged on 5/27/20.
 */
class SearchFragment @Inject constructor(
    private val viewModelProvider: Provider<SearchViewModel>
) : BaseFragment<
        SearchViewState,
        SearchViewEvent,
        SearchViewAction,
        SearchViewModel,
        FragmentSearchBinding>() {

    override val viewModel: SearchViewModel by viewModelWithProvider { viewModelProvider.get() }

    override val theme: Int = R.style.AppTheme

    override fun onCreateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSearchBinding {
        return FragmentSearchBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.backButton.postClickAction(SearchViewAction.ClickOnBack)
    }

    override fun renderViewState(viewState: SearchViewState) {
    }

    override fun renderViewEvent(viewEvent: SearchViewEvent) {
    }
}