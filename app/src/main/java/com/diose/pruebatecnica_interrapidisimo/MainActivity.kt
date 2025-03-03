package com.diose.pruebatecnica_interrapidisimo

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.diose.pruebatecnica_interrapidisimo.databinding.ActivityMainBinding
import com.diose.pruebatecnica_interrapidisimo.model.AuthUser
import com.diose.pruebatecnica_interrapidisimo.model.api.Retrofit
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    lateinit var retrofit: Retrofit
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        retrofit = Retrofit()
        val coroutine = CoroutineScope(Dispatchers.IO)
        coroutine.launch {
//            getVersion()
        }
        coroutine.launch {
//            getUser()
        }
        coroutine.launch {
            getTablas()
        }
        coroutine.launch {
//            getLocalidades()
        }
    }

    private suspend fun getVersion() {
        val version = retrofit.getRetrofit().getVersion()
        val res = version.body()
        if (version.isSuccessful){
            println(res)
        }else{
            "Error ${version.code()}"
        }
    }

    private suspend fun getUser() {
        val user = AuthUser(
            mac = "",
            nomAplicacion = "Controller APP",
            password = "SW50ZXIyMDIx\n",
            path = "",
            usuario = "cGFtLm1lcmVkeTIx\n"
        )
        val userAuth = retrofit.getRetrofit().auth(user)
        val resUser = userAuth.body()
        if (userAuth.isSuccessful){
            val userResponse = userAuth.body()
        }else{
            "Error ${userAuth.code()}"
        }
    }


    private suspend fun getTablas() {
        val tablas = retrofit.getRetrofit().getTablas()
        val res = tablas.body()
    }

    private suspend fun getLocalidades() {
        val localidades = retrofit.getRetrofit().getLocalidades()
        val res = localidades.body()
        if (localidades.isSuccessful){
            println("Size :${res!!.size}")
        }else{
            "Error ${localidades.code()}"
        }
    }


}