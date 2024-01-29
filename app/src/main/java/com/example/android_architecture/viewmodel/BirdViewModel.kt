package com.example.android_architecture.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android_architecture.model.RandomBirdGenerator
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class BirdViewModel : ViewModel() {

    init {
        getBird()
    }
    private var countValue = MutableLiveData<Int>(0)

    fun getCountValue() : LiveData<Int> {
        return countValue
    }

    fun incrementCountValue() {
        countValue.value = countValue.value as Int + 1
    }

    private fun getBird() {
        viewModelScope.launch {
            while (true) {
                val bird = RandomBirdGenerator.generateBird()
                withContext(Dispatchers.Main) {
                    countValue.value = bird.height!!
                }
            }
        }
    }

}