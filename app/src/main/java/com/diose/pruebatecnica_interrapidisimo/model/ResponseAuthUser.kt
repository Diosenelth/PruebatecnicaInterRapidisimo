package com.diose.pruebatecnica_interrapidisimo.model

import com.google.gson.annotations.SerializedName

data class ResponseAuthUser(

	@field:SerializedName("Nombre")
	val nombre: String? = null,

	@field:SerializedName("Cargo")
	val cargo: Any? = null,

	@field:SerializedName("TokenJWT")
	val tokenJWT: Any? = null,

	@field:SerializedName("MensajeResultado")
	val mensajeResultado: Int? = null,

	@field:SerializedName("IdLocalidad")
	val idLocalidad: String? = null,

	@field:SerializedName("Usuario")
	val usuario: String? = null,

	@field:SerializedName("Identificacion")
	val identificacion: String? = null,

	@field:SerializedName("NombreLocalidad")
	val nombreLocalidad: String? = null,

	@field:SerializedName("IdRol")
	val idRol: Any? = null,

	@field:SerializedName("ModulosApp")
	val modulosApp: List<ModulosAppItem?>? = null,

	@field:SerializedName("NomRol")
	val nomRol: String? = null,

	@field:SerializedName("Aplicaciones")
	val aplicaciones: Aplicaciones? = null,

	@field:SerializedName("Apellido2")
	val apellido2: String? = null,

	@field:SerializedName("Ubicaciones")
	val ubicaciones: List<UbicacionesItem?>? = null,

	@field:SerializedName("Apellido8")
	val apellido8: String? = null
)

data class AccionesMenuItem(

	@field:SerializedName("MEAIdMenu")
	val mEAIdMenu: Int? = null,

	@field:SerializedName("ACCNombre")
	val aCCNombre: Any? = null,

	@field:SerializedName("MEAEstado")
	val mEAEstado: Boolean? = null,

	@field:SerializedName("MEAIdMenuAccion")
	val mEAIdMenuAccion: Int? = null,

	@field:SerializedName("MEAIdAccion")
	val mEAIdAccion: Int? = null
)

data class ModulosAppItem(

	@field:SerializedName("MODIdModulo")
	val mODIdModulo: Int? = null,

	@field:SerializedName("MODOrden")
	val mODOrden: Int? = null,

	@field:SerializedName("MODNombre")
	val mODNombre: String? = null,

	@field:SerializedName("MODIdAplicacion")
	val mODIdAplicacion: Int? = null,

	@field:SerializedName("MODEstado")
	val mODEstado: Boolean? = null,

	@field:SerializedName("MODVisible")
	val mODVisible: Boolean? = null
)

data class Aplicaciones(

	@field:SerializedName("APLEstado")
	val aPLEstado: Boolean? = null,

	@field:SerializedName("APLVersion")
	val aPLVersion: Any? = null,

	@field:SerializedName("TotalPaginas")
	val totalPaginas: Int? = null,

	@field:SerializedName("APLIdAplicacion")
	val aPLIdAplicacion: Int? = null,

	@field:SerializedName("APLNombreAplicacion")
	val aPLNombreAplicacion: String? = null,

	@field:SerializedName("Paginas")
	val paginas: Int? = null,

	@field:SerializedName("APLRutaAplicacion")
	val aPLRutaAplicacion: Any? = null,

	@field:SerializedName("APLNombreCorto")
	val aPLNombreCorto: Any? = null,

	@field:SerializedName("Modulos")
	val modulos: List<ModulosItem?>? = null
)

data class MenusItem(

	@field:SerializedName("MENIdModulo")
	val mENIdModulo: Int? = null,

	@field:SerializedName("MENNombreCorto")
	val mENNombreCorto: String? = null,

	@field:SerializedName("MODNombre")
	val mODNombre: Any? = null,

	@field:SerializedName("MENEstado")
	val mENEstado: Boolean? = null,

	@field:SerializedName("MENNombre")
	val mENNombre: String? = null,

	@field:SerializedName("SubMenu")
	val subMenu: List<Any?>? = null,

	@field:SerializedName("MENUrl")
	val mENUrl: String? = null,

	@field:SerializedName("AccionesMenu")
	val accionesMenu: List<AccionesMenuItem?>? = null,

	@field:SerializedName("MENIdMenu")
	val mENIdMenu: Int? = null,

	@field:SerializedName("MENObservacion")
	val mENObservacion: Any? = null,

	@field:SerializedName("TotalPaginas")
	val totalPaginas: Int? = null,

	@field:SerializedName("MENIdMenuPadre")
	val mENIdMenuPadre: Int? = null,

	@field:SerializedName("MENIcono")
	val mENIcono: String? = null,

	@field:SerializedName("APLNombreAplicacion")
	val aPLNombreAplicacion: Any? = null
)

data class UbicacionesItem(

	@field:SerializedName("UBUIdUsuario")
	val uBUIdUsuario: String? = null,

	@field:SerializedName("IdCaja")
	val idCaja: Int? = null,

	@field:SerializedName("IdLocalidad")
	val idLocalidad: String? = null,

	@field:SerializedName("NombreCompletoLocalidad")
	val nombreCompletoLocalidad: String? = null,

	@field:SerializedName("UBUIdCentroServicios")
	val uBUIdCentroServicios: Int? = null,

	@field:SerializedName("NombreCentroServicios")
	val nombreCentroServicios: String? = null
)

data class ModulosItem(

	@field:SerializedName("MODNombreCorto")
	val mODNombreCorto: Any? = null,

	@field:SerializedName("TotalPaginas")
	val totalPaginas: Int? = null,

	@field:SerializedName("MODIdModulo")
	val mODIdModulo: Int? = null,

	@field:SerializedName("APLNombreAplicacion")
	val aPLNombreAplicacion: Any? = null,

	@field:SerializedName("MODNombre")
	val mODNombre: String? = null,

	@field:SerializedName("MODIdAplicacion")
	val mODIdAplicacion: Int? = null,

	@field:SerializedName("Menus")
	val menus: List<MenusItem?>? = null,

	@field:SerializedName("MODEstado")
	val mODEstado: Boolean? = null
)
