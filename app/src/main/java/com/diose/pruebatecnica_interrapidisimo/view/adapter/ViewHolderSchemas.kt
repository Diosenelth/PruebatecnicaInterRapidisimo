package com.diose.pruebatecnica_interrapidisimo.view.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.diose.pruebatecnica_interrapidisimo.databinding.ItemLocalityBinding
import com.diose.pruebatecnica_interrapidisimo.model.database.localities.Localities
import com.diose.pruebatecnica_interrapidisimo.model.database.schemas.Schemas

class ViewHolderSchemas(
    val view : View
): RecyclerView.ViewHolder(view) {

    val binding = ItemLocalityBinding.bind(view)

    fun render(schemas: Schemas){
        val id  = schemas.id.toString()
        binding.id.text = id
        binding.nombre.text = schemas.fechaActualizacionSincro
        binding.abrCiudad.text = schemas.queryCreacion
    }
}