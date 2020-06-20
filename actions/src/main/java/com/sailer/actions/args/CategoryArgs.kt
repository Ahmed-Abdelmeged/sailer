package com.sailer.actions.args

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Ahmed Abd-Elmeged on 6/1/20.
 */
@Parcelize
data class CategoryArgs(val categoryId: Long) : Parcelable {
    companion object {
        const val KEY = "com.sailer.shopping.extra.category"
    }
}