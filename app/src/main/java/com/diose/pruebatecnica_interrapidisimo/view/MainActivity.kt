package com.diose.pruebatecnica_interrapidisimo.view

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.transition.Visibility
import com.diose.pruebatecnica_interrapidisimo.R
import com.diose.pruebatecnica_interrapidisimo.databinding.ActivityMainBinding
import com.diose.pruebatecnica_interrapidisimo.model.api.Retrofit
import com.diose.pruebatecnica_interrapidisimo.model.database.AppDatabase
import com.diose.pruebatecnica_interrapidisimo.model.database.user.User
import com.diose.pruebatecnica_interrapidisimo.model.showMessageError
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var retrofit: Retrofit
    private lateinit var db: AppDatabase

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

        //base de datos
        db = AppDatabase.getInstance(this)
        retrofit = Retrofit()

        CoroutineScope(Dispatchers.IO).launch {
            getVersion()
        }
    }

    private suspend fun getVersion() {
        try {
            val version = retrofit.getRetrofit().getVersion()
            val res = version.body()
            if (version.isSuccessful){
                val userDao = db.userDao()
                val users: List<User> = userDao.getAll()
                 try {
                     //si la base de datos esta vacia se crea el usuario con id web solamente
                    if (users.isEmpty()){
                        val idWeb = res?.toInt()?:0
                        val user = User(
                            uid = 1,
                            usuario = "",
                            versioWeb = idWeb,
                            identificacion = "",
                            nombre = "",
                        )
                        db.userDao().insertAll(user)
                        withContext(Dispatchers.Main){ mainFragment() }
                    }else{
                        //si la base de datos no esta vacia se compara la version web con la local
                        withContext(Dispatchers.Main) {
                            val idWeb = res?.toInt() ?: 0
                            val user = users.first()
                            //si la version web es diferente se muestra un dialogo para actualizar
                            showAlert(user.versioWeb, idWeb) {
                                user.versioWeb = idWeb
                                CoroutineScope(Dispatchers.IO).launch{db.userDao().update(user)}
                                mainFragment()
                            }
                        }
                    }
                 }catch (_: Exception){}
            }else{
                withContext(Dispatchers.Main){this@MainActivity.showMessageError(version.errorBody()?.charStream()!!.readText()){} }
            }
        }catch (e:Exception){
            withContext(Dispatchers.Main){
                this@MainActivity.showMessageError(e.message.toString()){this@MainActivity.finish()}
            }
        }
    }

    private fun showAlert(idLocal: Int, idWeb: Int, function: () -> Unit){
        if (idLocal == idWeb) {
            function()
            return
        }
        val alert = AlertDialog.Builder(this)
        alert.setTitle(getString(R.string.update_data))
        if (idLocal > idWeb){
            alert.setMessage(getString(R.string.new_version_local))
        }else {
            alert.setMessage(getString(R.string.new_version))
        }
        alert.setPositiveButton(getString(R.string.accept)) { _, _ ->
            function()
        }
        alert.create().show()
    }

    private fun mainFragment(){
        //ocultar progress
        binding.progress.visibility = View.GONE
        //cambiar fragment
        val fragment = UserFragment()
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, fragment)
            .commit()
    }

}