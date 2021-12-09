package com.digitalhouse.dhwallet.model

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Parcelable
import android.widget.TextView
import androidx.core.graphics.ColorUtils
import androidx.core.graphics.toColorInt
import com.digitalhouse.dhwallet.R
import kotlinx.android.parcel.Parcelize

@Parcelize
class Transaction(
    val title: String,
    val subtitle: String,
    val value: String,
    val img: String,
) : Parcelable

