package com.ryanmhildan.exchangerate.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Country(
    var name: String,
    var buyy: String,
    var sell: String,
    var Photo: Int
) : Parcelable
