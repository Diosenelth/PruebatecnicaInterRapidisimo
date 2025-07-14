package com.diose.pruebatecnica_interrapidisimo.model

import com.google.gson.annotations.SerializedName

data class ResponseSchema(

	@field:SerializedName("ResponseSchema")
	val responseSchema: List<ResponseSchemaItem?>? = null
)

data class ResponseSchemaItem(

	@field:SerializedName("BatchSize")
	val batchSize: Int? = null,

	@field:SerializedName("NumeroCampos")
	val numeroCampos: Int? = null,

	@field:SerializedName("Filtro")
	val filtro: String? = null,

	@field:SerializedName("FechaActualizacionSincro")
	val fechaActualizacionSincro: String? = null,

	@field:SerializedName("QueryCreacion")
	val queryCreacion: String? = null,

	@field:SerializedName("Error")
	val error: Any? = null,

	@field:SerializedName("NombreTabla")
	val nombreTabla: String? = null,

	@field:SerializedName("Pk")
	val pk: String? = null,

	@field:SerializedName("MetodoApp")
	val metodoApp: Any? = null
)
