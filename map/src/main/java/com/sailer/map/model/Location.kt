package com.sailer.map.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by Ahmed Abd-Elmeged on 6/17/20.
 */
@Parcelize
data class Location(
    val latitude: Float,
    val longitude: Float
) : Parcelable