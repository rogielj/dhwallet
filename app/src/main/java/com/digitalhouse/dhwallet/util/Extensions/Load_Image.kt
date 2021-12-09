package com.digitalhouse.dhwallet.util.Extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.load(url: String){
    Glide.with(this.context).load(url).circleCrop().into(this)
}
