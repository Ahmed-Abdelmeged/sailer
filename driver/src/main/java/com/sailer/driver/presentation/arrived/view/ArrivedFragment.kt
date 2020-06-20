package com.sailer.driver.presentation.arrived.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import com.sailer.core.base.view.BaseFragment
import com.sailer.core.extension.exhaustive
import com.sailer.core.extension.hostedViewModel
import com.sailer.core.extension.shortSnackbar
import com.sailer.driver.R
import com.sailer.driver.databinding.FragmentArrivedBinding
import com.sailer.driver.presentation.arrived.viewmodel.ArrivedViewModel
import com.sailer.driver.presentation.arrived.viewstate.ArrivedViewAction
import com.sailer.driver.presentation.arrived.viewstate.ArrivedViewEvent
import com.sailer.driver.presentation.arrived.viewstate.ArrivedViewState
import com.sailer.map.model.Location
import com.sailer.map.view.MapRequestKeys

/**
 * Created by Ahmed Abd-Elmeged on 6/5/20.
 */
class ArrivedFragment : BaseFragment<
        ArrivedViewState,
        ArrivedViewEvent,
        ArrivedViewAction,
        ArrivedViewModel,
        FragmentArrivedBinding>() {

    override val viewModel: ArrivedViewModel by hostedViewModel()

    override val theme: Int = R.style.AppTheme

    override fun onCreateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentArrivedBinding {
        return FragmentArrivedBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.backButton.postClickAction(ArrivedViewAction.ClickOnBack)
        binding.dropPinButton.postClickAction(ArrivedViewAction.OpenMap)

        setFragmentResultListener(MapRequestKeys.MAP) { _, bundle ->
            val location: Location? = bundle.getParcelable(MapRequestKeys.KEY_LOCATION)
            if (location != null) {
                postAction(ArrivedViewAction.DropPinLocation(location))
            }
        }
    }

    override fun renderViewState(viewState: ArrivedViewState) {
    }

    override fun renderViewEvent(viewEvent: ArrivedViewEvent) {
        when (viewEvent) {
            is ArrivedViewEvent.MissingDropPinLocation ->
                shortSnackbar(binding.arrivedContainer, "Please enter your location")
        }.exhaustive
    }
}