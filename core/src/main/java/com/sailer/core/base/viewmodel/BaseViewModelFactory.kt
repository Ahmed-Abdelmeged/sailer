package com.sailer.core.base.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

/**
 * Created by Ahmed Abd-Elmeged on 5/15/20.
 */
@Suppress("UNCHECKED_CAST")
abstract class BaseViewModelFactory<VM : ViewModel> : ViewModelProvider.Factory {

    abstract fun createViewModel(): VM

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return createViewModel() as T
    }
}