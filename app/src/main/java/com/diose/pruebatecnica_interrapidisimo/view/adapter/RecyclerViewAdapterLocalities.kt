package com.diose.pruebatecnica_interrapidisimo.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.diose.pruebatecnica_interrapidisimo.databinding.ItemLocalityBinding
import com.diose.pruebatecnica_interrapidisimo.model.database.localities.Localities

class RecyclerViewAdapterLocalities (
    private val list : List<Localities>
): RecyclerView.Adapter<ViewHolderLocalities>() {
    private lateinit var binding: ItemLocalityBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderLocalities {
        binding = ItemLocalityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolderLocalities(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolderLocalities, position: Int) {
        holder.render(list[position])
    }

    override fun getItemCount(): Int = list.size


}