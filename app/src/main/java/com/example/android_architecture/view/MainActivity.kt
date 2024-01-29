package com.example.android_architecture.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import com.example.android_architecture.databinding.ActivityMainBinding
import com.example.android_architecture.databinding.ActivityMainBinding.inflate


import com.example.android_architecture.viewmodel.BirdViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val counterViewModel : BirdViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflate(layoutInflater)
        setContentView(binding.root)
        observeData()
    }

    private fun observeData() {
        counterViewModel.getCountValue().observe(this) { x ->
            binding.tvInfo.text = x.toString()
        }
    }

    fun increaseCounter(view: View) {
        counterViewModel.incrementCountValue()
    }
}