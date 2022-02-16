package com.shirobutton.common_mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    private val mutableImageUrlObservable = MutableLiveData<String>()
    val imageUrlObservable: LiveData<String> = mutableImageUrlObservable

    fun fetch() {
        mutableImageUrlObservable.value = "https://purr.objects-us-east-1.dream.io/i/tumblr_luhf8e8rwh1qaoexto1_1280.jpg"
    }
}