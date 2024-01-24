package com.example.android_architecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.android_architecture.databinding.ActivityMainBinding
import com.example.android_architecture.databinding.ActivityMainBinding.inflate

class MainActivity : AppCompatActivity() {
    lateinit var binding :ActivityMainBinding
    var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun increaseCounter(view: View) {
        ++counter
        binding.tvInfo.text = counter.toString()
    }
}