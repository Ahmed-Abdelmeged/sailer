package com.sailer.map.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import com.sailer.core.base.view.BaseFragment
import com.sailer.core.extension.exhaustive
import com.sailer.core.extension.shortSnackbar
import com.sailer.core.extension.viewModelWithProvider
import com.sailer.map.R
import com.sailer.map.databinding.FragmentDropPinMapBinding
import com.sailer.map.model.Location
import com.sailer.map.viewmodel.DropPinMapViewModel
import com.sailer.map.viewstate.DropPinMapViewAction
import com.sailer.map.viewstate.DropPinMapViewEvent
import com.sailer.map.viewstate.DropPinMapViewState
import javax.inject.Inject
import javax.inject.Provider

/**
 * Created by Ahmed Abd-Elmeged on 6/10/20.
 */
class DropPinMapFragment @Inject constructor(
    private val viewModelProvider: Provider<DropPinMapViewModel>
) : BaseFragment<
        DropPinMapViewState,
        DropPinMapViewEvent,
        DropPinMapViewAction,
        DropPinMapViewModel,
        FragmentDropPinMapBinding>() {

    override val viewModel: DropPinMapViewModel by viewModelWithProvider { viewModelProvider.get() }

    override val theme: Int = R.style.AppTheme

    override fun onCreateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDropPinMapBinding {
        return FragmentDropPinMapBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.backButton.postClickAction(DropPinMapViewAction.ClickOnBack)
        binding.confirmButton.postClickAction(DropPinMapViewAction.ConfirmDropPin)

        //Get the location from Google map
        postAction(DropPinMapViewAction.DropPinLocation(Location(latitude = 0f, longitude = 0f)))
    }

    override fun renderViewState(viewState: DropPinMapViewState) {
    }

    override fun renderViewEvent(viewEvent: DropPinMapViewEvent) {
        when (viewEvent) {
            is DropPinMapViewEvent.SetDropPinLocation -> {
                setFragmentResult(
                    MapRequestKeys.MAP,
                    bundleOf(MapRequestKeys.KEY_LOCATION to viewEvent.location)
                )
            }

            is DropPinMapViewEvent.MissingLocation -> {
                shortSnackbar(binding.mapContainer, "Required location permission")
            }
        }.exhaustive
    }
}