package com.sailer.core.extension

import android.content.Intent
import android.os.Build
import android.provider.Settings
import androidx.annotation.MainThread
import androidx.fragment.app.Fragment
import androidx.fragment.app.createViewModelLazy
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.sailer.core.base.view.BaseFragment
import com.sailer.core.navigation.CoordinatorHost

/**
 * Created by Ahmed Abd-Elmeged on 5/28/20.
 */
fun Fragment.hideKeyboard() {
    requireActivity().hideKeyboard()
}

fun Fragment.launchInternetSettingPanel() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        startActivity(Intent(Settings.Panel.ACTION_INTERNET_CONNECTIVITY))
    }
}

@MainThread
inline fun <reified VM : ViewModel> BaseFragment<*, *, *, *, *>.hostedViewModel(
    noinline ownerProducer: () -> ViewModelStoreOwner = { this },
    noinline factoryProducer: (() -> ViewModelProvider.Factory)? = {
        val coordinator = (requireActivity() as CoordinatorHost<*>).coordinator
        coordinator.onCreateViewModelFactory(this)
    }
) = createViewModelLazy(VM::class, { ownerProducer().viewModelStore }, factoryProducer)