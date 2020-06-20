package com.sailer.core.base.view

import android.content.Context
import android.os.Bundle
import android.view.ContextThemeWrapper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.StyleRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.viewbinding.ViewBinding
import com.sailer.core.base.viewmodel.BaseViewModel
import com.sailer.core.event.EventObserver
import com.sailer.core.extension.hideKeyboard
import com.sailer.core.navigation.Coordinator
import com.sailer.core.navigation.CoordinatorHost
import com.sailer.core.navigation.Displayable
import com.sailer.core.viewstate.ViewAction
import com.sailer.core.viewstate.ViewEvent
import com.sailer.core.viewstate.ViewState

/**
 * Created by Ahmed Abd-Elmeged on 6/15/20.
 */
abstract class BaseFragment<
        VS : ViewState,
        VE : ViewEvent,
        VA : ViewAction,
        VM : BaseViewModel<VS, VE, VA>,
        VB : ViewBinding
        > : Fragment(), Displayable {

    protected abstract val viewModel: VM

    @get:StyleRes
    protected abstract val theme: Int

    private var _binding: VB? = null

    protected val binding: VB get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //create ContextThemeWrapper from the original Activity Context with the custom theme.
        val contextThemeWrapper: Context = ContextThemeWrapper(requireActivity(), theme)

        //clone the inflater using the ContextThemeWrapper.
        val localInflater = inflater.cloneInContext(contextThemeWrapper)

        _binding = onCreateBinding(localInflater, container)
        return binding.root
    }

    abstract fun onCreateBinding(inflater: LayoutInflater, container: ViewGroup?): VB

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.viewState.observe(viewLifecycleOwner, Observer { renderViewState(it) })
        viewModel.viewEvent.observe(viewLifecycleOwner, EventObserver { renderViewEvent(it) })

        viewModel.coordinatorEvent.observe(viewLifecycleOwner, EventObserver {
            getCoordinator().onEvent(it)
        })
    }

    abstract fun renderViewState(viewState: VS)

    abstract fun renderViewEvent(viewEvent: VE)

    protected fun postAction(action: VA) {
        viewModel.postAction(action)
    }

    fun View.postClickAction(action: VA) {
        setOnClickListener { postAction(action) }
    }

    private fun getCoordinator(): Coordinator {
        return (requireActivity() as CoordinatorHost<*>).coordinator
    }

    override fun onResume() {
        super.onResume()
        hideKeyboard()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}