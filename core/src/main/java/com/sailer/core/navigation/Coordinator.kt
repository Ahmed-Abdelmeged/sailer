package com.sailer.core.navigation

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController

/**
 * Created by Ahmed Abd-Elmeged on 5/5/20.
 */
abstract class Coordinator(val featureNavigator: FeatureNavigator) {

    var navController: NavController? = null

    var activity: AppCompatActivity? = null

    abstract fun onCreateViewModelFactory(screen: Displayable): ViewModelProvider.Factory

    abstract fun onEvent(event: Any)

    fun back() {
        if (navController?.popBackStack() == false) {
            activity?.onBackPressed()
        }
    }

    fun finish() {
        activity?.finish()
    }

    fun finishWithResult(resultIntent: Intent) {
        activity?.setResult(Activity.RESULT_OK, resultIntent)
        activity?.finish()
    }
}