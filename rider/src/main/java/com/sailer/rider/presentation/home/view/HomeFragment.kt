package com.sailer.rider.presentation.home.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sailer.core.base.view.BaseFragment
import com.sailer.core.extension.viewModelWithProvider
import com.sailer.rider.R
import com.sailer.rider.databinding.FragmentHomeBinding
import com.sailer.rider.presentation.home.viewmodel.HomeViewModel
import com.sailer.rider.presentation.home.viewstate.HomeViewAction
import com.sailer.rider.presentation.home.viewstate.HomeViewEvent
import com.sailer.rider.presentation.home.viewstate.HomeViewState
import javax.inject.Inject
import javax.inject.Provider

/**
 * Created by Ahmed Abd-Elmeged on 6/5/20.
 */
class HomeFragment @Inject constructor(
    private val viewModelProvider: Provider<HomeViewModel>
) : BaseFragment<
        HomeViewState,
        HomeViewEvent,
        HomeViewAction,
        HomeViewModel,
        FragmentHomeBinding>() {

    override val viewModel: HomeViewModel by viewModelWithProvider { viewModelProvider.get() }

    override val theme: Int = R.style.AppTheme

    override fun onCreateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.backButton.postClickAction(HomeViewAction.ClickOnBack)
        binding.shoppingButton.postClickAction(HomeViewAction.OpenShopping)
    }

    override fun renderViewState(viewState: HomeViewState) {
    }

    override fun renderViewEvent(viewEvent: HomeViewEvent) {
    }
}