package com.shirobutton.common_mvvm

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.shirobutton.common_mvvm.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment: Fragment(R.layout.fragment_home) {

    private val viewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentHomeBinding.bind(view)
        val imageView = binding.imageView
        viewModel.imageUrlObservable.observe(viewLifecycleOwner) {
            Glide.with(imageView)
                .load(it)
                .into(imageView)
        }
        viewModel.errorObservable.observe(viewLifecycleOwner) {
            Toast.makeText(
                context,
                "エラーが起きました",
                Toast.LENGTH_LONG
            ).show()
        }
        viewModel.fetch()
    }
}