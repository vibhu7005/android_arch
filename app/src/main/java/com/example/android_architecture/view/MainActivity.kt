package com.example.android_architecture.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.viewModels
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.transaction
import androidx.lifecycle.ViewModelProvider
import com.example.android_architecture.databinding.ActivityMainBinding
import com.example.android_architecture.databinding.ActivityMainBinding.inflate


import com.example.android_architecture.viewmodel.BirdViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private lateinit var counterViewModel : BirdViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(::binding.isInitialized)
        binding = inflate(layoutInflater)
        setContentView(binding.root)
        counterViewModel = ViewModelProvider(this)[BirdViewModel::class.java]
        observeData()
    }

    private fun observeData() {
        counterViewModel.getCountValue().observe(this) { x ->
            binding.tvInfo.text = x.toString()
        }
    }

    fun openFragment(view: View) {
        val fragment = BirdsFragment.newInstance()
        val transactions = this.supportFragmentManager.beginTransaction()
        transactions.replace(binding.fragmentContainer.id, fragment, null).commit()
    }

    fun increment(view: View) {
        counterViewModel.incrementCountValue()
    }

    fun openNextActivity(view: View) {
        val intent = Intent(this, MainActivity2::class.java)
        startActivity(intent)
    }

    override fun onStop() {
        Log.d("jordiee", "stopped")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("jordiee", "destroyed")
        super.onDestroy()
    }
}