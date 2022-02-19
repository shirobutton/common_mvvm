package com.shirobutton.common_mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val mutableImageUrlObservable = MutableLiveData<String>()
    val imageUrlObservable: LiveData<String> = mutableImageUrlObservable

    private val mutableErrorObservable = MutableLiveData<Throwable>()
    val errorObservable: LiveData<Throwable> = mutableErrorObservable

    private val repository = HomeRepository()

    fun fetch() {
        viewModelScope.launch {
            repository.getImageUrl()
                .onSuccess(mutableImageUrlObservable::setValue)
                .onFailure(mutableErrorObservable::setValue)
        }
    }
}