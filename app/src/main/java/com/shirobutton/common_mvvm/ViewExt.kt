package com.shirobutton.common_mvvm

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("load")
fun ImageView.load(url: String?) {
    Glide.with(this)
        .load(url)
        .into(this)
}