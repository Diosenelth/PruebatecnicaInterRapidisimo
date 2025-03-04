package com.diose.pruebatecnica_interrapidisimo.view.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.diose.pruebatecnica_interrapidisimo.databinding.ItemLocalityBinding
import com.diose.pruebatecnica_interrapidisimo.model.database.localities.Localities

class ViewHolderLocalities(
    val view : View
): RecyclerView.ViewHolder(view) {

    val binding = ItemLocalityBinding.bind(view)

    fun render(localities: Localities){
        val id  = localities.id.toString()
        binding.id.text = id
        binding.nombre.text = localities.nombreCompleto
        binding.abrCiudad.text = localities.abreviacionCiudad
    }
}