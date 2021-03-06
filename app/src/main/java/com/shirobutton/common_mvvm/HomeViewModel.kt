package com.shirobutton.common_mvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: HomeRepository) : ViewModel() {
    private val mutableImageUrlObservable = MutableLiveData<String>()
    val imageUrlObservable: LiveData<String> = mutableImageUrlObservable

    private val mutableErrorObservable = MutableLiveData<Throwable>()
    val errorObservable: LiveData<Throwable> = mutableErrorObservable

    fun fetch() {
        viewModelScope.launch {
            repository.getImageUrl()
                .onSuccess(mutableImageUrlObservable::setValue)
                .onFailure(mutableErrorObservable::setValue)
        }
    }
}