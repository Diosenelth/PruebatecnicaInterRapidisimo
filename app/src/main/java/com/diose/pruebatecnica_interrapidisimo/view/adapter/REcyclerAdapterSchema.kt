package com.diose.pruebatecnica_interrapidisimo.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.diose.pruebatecnica_interrapidisimo.databinding.ItemLocalityBinding
import com.diose.pruebatecnica_interrapidisimo.model.database.localities.Localities
import com.diose.pruebatecnica_interrapidisimo.model.database.schemas.Schemas


class REcyclerAdapterSchema (
    private val list : List<Schemas>
): RecyclerView.Adapter<ViewHolderSchemas>() {
    private lateinit var binding: ItemLocalityBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderSchemas {
        binding = ItemLocalityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolderSchemas(binding.root)
    }

    override fun onBindViewHolder(holder: ViewHolderSchemas, position: Int) {
        holder.render(list[position])
    }

    override fun getItemCount(): Int = list.size


}