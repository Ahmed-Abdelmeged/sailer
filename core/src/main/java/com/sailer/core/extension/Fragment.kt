package com.sailer.core.extension

import android.content.Intent
import android.os.Build
import android.provider.Settings
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
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

/**
 * The ViewModelStoreOwner controls the scope of the ViewModel.
 * It may be overridden with a different ViewModelStoreOwner,
 * such as the host Activity or the parent fragment, in order to
 * scope the lifetime of the ViewModel to the lifetime of the
 * ViewModelStoreOwner that is passed in.
 * https://desmondtzq.com/2019/10/25/fragment-factory-dagger/
 */
inline fun <reified T : ViewModel> Fragment.viewModelWithProvider(
    noinline ownerProducer: () -> ViewModelStoreOwner = { this },
    crossinline provider: () -> T
) = viewModels<T>(ownerProducer) {
    object : ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            @Suppress("UNCHECKED_CAST")
            return provider.invoke() as T
        }
    }
}

fun getHostFragment(fragment: Fragment?): Fragment? {
    if (fragment == null) return null

    if (fragment is CoordinatorHost<*>) return fragment

    return getHostFragment(fragment.parentFragment)
}

fun Fragment.getCoordinatorHost(): CoordinatorHost<*> {
    return (getHostFragment(this) as? CoordinatorHost<*>)
        ?: (this.requireActivity() as? CoordinatorHost<*>)
        ?: throw IllegalArgumentException("The fragment must be opened in a CoordinatorHost fragment/activity")
}