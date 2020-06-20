package com.sailer.core.extension

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/**
 * Created by Ahmed Abd-Elmeged on 5/22/20.
 */
fun <T> MutableLiveData<T>.asLiveData() = this as LiveData<T>