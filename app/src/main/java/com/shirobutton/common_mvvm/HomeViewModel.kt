package com.shirobutton.common_mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    private val mutableImageUrlObservable = MutableLiveData<String>()
    val imageUrlObservable: LiveData<String> = mutableImageUrlObservable

    private val repository = HomeRepository()

    fun fetch() {
        mutableImageUrlObservable.value = repository.getImageUrl()
    }
}