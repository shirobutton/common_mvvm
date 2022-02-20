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

    private val binding by viewBinding(FragmentHomeBinding::bind)
    private val viewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe(viewModel.imageUrlObservable, ::onChangeImage)
        observe(viewModel.errorObservable) {
            Toast.makeText(
                context,
                "エラーが起きました",
                Toast.LENGTH_LONG
            ).show()
        }
        viewModel.fetch()
    }

    private fun onChangeImage(imageUrl: String?) {
        val imageView = binding?.imageView ?: return
        Glide.with(imageView)
            .load(imageUrl)
            .into(imageView)
    }
}