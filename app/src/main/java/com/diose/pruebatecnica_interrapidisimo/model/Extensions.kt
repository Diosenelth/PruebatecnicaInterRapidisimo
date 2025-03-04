package com.diose.pruebatecnica_interrapidisimo.model

import android.content.Context
import androidx.appcompat.app.AlertDialog

fun Context.showMessageError(mss : String, action : () -> Unit){
    //mensaje de error
    val alert = AlertDialog.Builder(this)
    alert.setTitle("Error")
    alert.setMessage(mss)
    alert.setPositiveButton("Aceptar",{ _, _ ->
        action()
        alert.create().dismiss()
    })
    alert.create().show()
}