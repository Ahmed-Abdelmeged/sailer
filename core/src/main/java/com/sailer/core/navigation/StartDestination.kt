package com.sailer.core.navigation

import android.os.Bundle
import androidx.annotation.IdRes

/**
 * Created by Ahmed Abd-Elmeged on 5/6/20.
 */
data class StartDestination(
    @IdRes val destination: Int,
    val args: Bundle? = null
)