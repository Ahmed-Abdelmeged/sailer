package com.sailer.core.extension

import android.view.View
import com.google.android.material.snackbar.Snackbar

/**
 * Created by Ahmed Abd-Elmeged on 5/29/20.
 */

fun shortSnackbar(container: View, text: String) {
    Snackbar.make(container, text, Snackbar.LENGTH_SHORT).show()
}
