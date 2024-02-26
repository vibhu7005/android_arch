package com.example.android_architecture.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_architecture.model.RandomBirdGenerator
import kotlinx.coroutines.launch
class BirdViewModel(val state : SavedStateHandle) : ViewModel() {

    init {
        Log.d("vaibhav", "hello")
//        getBird()
    }
    private var countValue = state.getLiveData<Int>("countKey")

    fun getCountValue() : LiveData<Int> {
        return countValue
    }

    fun incrementCountValue() {
        if (countValue.value == null) countValue.value = 1
        else countValue.value = countValue.value as Int + 1
    }

    private fun getBird() {
        viewModelScope.launch {
            while (true) {
                val bird = RandomBirdGenerator.generateBird()
                countValue.postValue(bird.height!!)

            }
        }
    }

    override fun onCleared() {
        Log.d("jordiee", "onCleared")
        super.onCleared()
    }

}