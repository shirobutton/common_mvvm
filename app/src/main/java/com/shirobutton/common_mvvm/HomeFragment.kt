package com.shirobutton.common_mvvm

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.shirobutton.common_mvvm.databinding.FragmentHomeBinding

class HomeFragment: Fragment(R.layout.fragment_home) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentHomeBinding.bind(view)
        val imageView = binding.imageView
        Glide.with(imageView)
            .load("https://purr.objects-us-east-1.dream.io/i/tumblr_luhf8e8rwh1qaoexto1_1280.jpg")
            .into(imageView)
    }
}