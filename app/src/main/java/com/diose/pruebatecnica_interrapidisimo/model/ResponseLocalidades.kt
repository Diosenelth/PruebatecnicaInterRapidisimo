package com.diose.pruebatecnica_interrapidisimo.model

import com.google.gson.annotations.SerializedName

data class ResponseLocalidades(

	@field:SerializedName("IdTipoLocalidad")
	val idTipoLocalidad: String? = null,

	@field:SerializedName("Nombre")
	val nombre: String? = null,

	@field:SerializedName("EstadoRegistro")
	val estadoRegistro: Int? = null,

	@field:SerializedName("IdCentroServicio")
	val idCentroServicio: Int? = null,

	@field:SerializedName("CodigoPostal")
	val codigoPostal: String? = null,

	@field:SerializedName("ValorRecogida")
	val valorRecogida: Any? = null,

	@field:SerializedName("NombreAncestroTGrado")
	val nombreAncestroTGrado: Any? = null,

	@field:SerializedName("IdAncestroTGrado")
	val idAncestroTGrado: Any? = null,

	@field:SerializedName("PermitePreEnviosPunto")
	val permitePreEnviosPunto: Boolean? = null,

	@field:SerializedName("NombreTipoLocalidad")
	val nombreTipoLocalidad: Any? = null,

	@field:SerializedName("EtiquetaEntrega")
	val etiquetaEntrega: Boolean? = null,

	@field:SerializedName("NombreZona")
	val nombreZona: String? = null,

	@field:SerializedName("HoraMaxRecogida")
	val horaMaxRecogida: Int? = null,

	@field:SerializedName("IdLocalidad")
	val idLocalidad: String? = null,

	@field:SerializedName("IdAncestroSGrado")
	val idAncestroSGrado: String? = null,

	@field:SerializedName("AbreviacionCiudad")
	val abreviacionCiudad: String? = null,

	@field:SerializedName("IdAncestroPGrado")
	val idAncestroPGrado: String? = null,

	@field:SerializedName("NombreCompleto")
	val nombreCompleto: String? = null,

	@field:SerializedName("Indicativo")
	val indicativo: String? = null,

	@field:SerializedName("HoraMinRecogida")
	val horaMinRecogida: Int? = null,

	@field:SerializedName("AsignadoEnZona")
	val asignadoEnZona: Boolean? = null,

	@field:SerializedName("AsignadoEnZonaOrig")
	val asignadoEnZonaOrig: Boolean? = null,

	@field:SerializedName("NombreAncestroPGrado")
	val nombreAncestroPGrado: String? = null,

	@field:SerializedName("NombreAncestroSGrado")
	val nombreAncestroSGrado: Any? = null,

	@field:SerializedName("NombreCorto")
	val nombreCorto: String? = null,

	@field:SerializedName("TiposLocalidades")
	val tiposLocalidades: Any? = null,

	@field:SerializedName("DispoLocalidad")
	val dispoLocalidad: Boolean? = null,

	@field:SerializedName("PermiteRecogida")
	val permiteRecogida: Boolean? = null,

	@field:SerializedName("SeGeorreferencia")
	val seGeorreferencia: Boolean? = null
)
