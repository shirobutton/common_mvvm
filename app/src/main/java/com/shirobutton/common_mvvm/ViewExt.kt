package com.shirobutton.common_mvvm

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.load(url: String?) {
    Glide.with(this)
        .load(url)
        .into(this)
}