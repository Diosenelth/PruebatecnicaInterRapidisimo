package com.diose.pruebatecnica_interrapidisimo.model

import android.content.Context
import androidx.appcompat.app.AlertDialog

fun Context.showMessageError(mss : String){
    val alert = AlertDialog.Builder(this)
    alert.setTitle("Error")
    alert.setMessage(mss)
    alert.setPositiveButton("Aceptar",{ _, _ ->
        alert.create().dismiss()
    })
    alert.create().show()
}