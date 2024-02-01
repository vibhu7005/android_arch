package com.example.android_architecture.view

import android.os.Build.VERSION_CODES.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.android_architecture.R
import com.example.android_architecture.viewmodel.BirdViewModel

class MainActivity2 : AppCompatActivity() {
    private lateinit var viewModel : BirdViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        viewModel = ViewModelProvider(this)[BirdViewModel::class.java]
        viewModel.getCountValue().observe(this)  { x->
            Toast.makeText(this, x.toString()+"ko", Toast.LENGTH_LONG).show()
        }
    }
}