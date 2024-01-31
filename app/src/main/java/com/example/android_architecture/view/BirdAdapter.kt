package com.example.android_architecture.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.get
import androidx.recyclerview.widget.RecyclerView
import com.example.android_architecture.R
import com.example.android_architecture.databinding.ItemBirdBinding
import com.example.android_architecture.model.Bird

class BirdAdapter(val birdList: ArrayList<Bird>) : RecyclerView.Adapter<BirdAdapter.BirdViewHolder>() {

    inner class BirdViewHolder(val binding : ItemBirdBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(bird : Bird) {
            binding.birdname.text = bird.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BirdViewHolder {
        val binding = ItemBirdBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BirdViewHolder(binding)
    }

    override fun getItemCount(): Int = birdList.size

    override fun onBindViewHolder(holder: BirdViewHolder, position: Int) {
        holder.bind(birdList[position])
    }
}