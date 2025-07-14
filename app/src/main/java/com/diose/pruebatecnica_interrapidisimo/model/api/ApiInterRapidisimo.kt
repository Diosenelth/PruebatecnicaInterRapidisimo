package com.diose.pruebatecnica_interrapidisimo.model.api

import com.diose.pruebatecnica_interrapidisimo.model.AuthUser
import com.diose.pruebatecnica_interrapidisimo.model.ResponseAuthUser
import com.diose.pruebatecnica_interrapidisimo.model.ResponseLocalidades
import com.diose.pruebatecnica_interrapidisimo.model.ResponseSchemaItem
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST


interface ApiInterRapidisimo {
    @GET("apicontrollerpruebas/api/ParametrosFramework/ConsultarParametrosFramework/VPStoreAppControl")
    suspend fun getVersion() : Response<String>

    @Headers(
        "Usuario: pam.meredy21",
        "Identificacion: 987204545",
        "Accept: text/json",
        "IdUsuario: pam.meredy21",
        "IdCentroServicio: 1295",
        "NombreCentroServicio: PTO/BOGOTA/CUND/COL/OF PRINCIPAL - CRA30#7-45",
        "IdAplicativoOrigen:9",
        "Content-Type: application/json",
    )
    @POST("FtEntregaElectronica/MultiCanales/ApiSeguridadPruebas/api/Seguridad/AuthenticaUsuarioApp")
    suspend fun auth(@Body user : AuthUser) : Response<ResponseAuthUser>

    @Headers(
        "Usuario: Controller",
    )
    @GET("apicontrollerpruebas/api/SincronizadorDatos/ObtenerEsquema/true")
    suspend fun getTablas() : Response<List<ResponseSchemaItem>>//no esta funcionando

    @GET("apicontrollerpruebas/api/ParametrosFramework/ObtenerLocalidadesRecogidas")
    suspend fun getLocalidades() : Response<List<ResponseLocalidades>>
}