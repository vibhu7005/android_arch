package com.example.android_architecture.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.android_architecture.R
import com.example.android_architecture.databinding.FragmentBirdsBinding
import com.example.android_architecture.viewmodel.BirdViewModel

class BirdsFragment : Fragment() {
    private lateinit var binding: FragmentBirdsBinding
    private val birdsViewModel : BirdViewModel by viewModels()


    companion object {

        fun newInstance(): BirdsFragment {
            return BirdsFragment()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBirdsBinding.inflate(layoutInflater, container, false)
        val mananger = LinearLayoutManager(activity)
        binding.rvBirds.layoutManager = mananger
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initObservers()
    }

    fun initObservers() {
        birdsViewModel.getCountValue().observe(requireActivity()) { x ->
            binding.tvInfo.text = x.toString()
        }
    }


}