package com.diose.pruebatecnica_interrapidisimo.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.diose.pruebatecnica_interrapidisimo.databinding.FragmentMainBinding
import com.diose.pruebatecnica_interrapidisimo.model.AuthUser
import com.diose.pruebatecnica_interrapidisimo.model.api.Retrofit
import com.diose.pruebatecnica_interrapidisimo.model.database.AppDatabase
import com.diose.pruebatecnica_interrapidisimo.model.database.user.User
import com.diose.pruebatecnica_interrapidisimo.model.showMessageError
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class UserFragment : Fragment() {

    private var _binding : FragmentMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var retrofit: Retrofit
    private lateinit var db: AppDatabase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentMainBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        db = AppDatabase.getInstance(requireContext())

        val users = db.userDao().getAll()
        val user = users.first()
        if (user.usuario.isEmpty() || user.identificacion.isEmpty() || user.nombre.isEmpty()){
            retrofit = Retrofit()
            CoroutineScope(Dispatchers.IO).launch {
                getUser()
            }
        }else{
            showInfoUser(user)
        }
    }

    private fun showInfoUser(user: User) {
        binding.apply {
            usuario.text = user.usuario
            identificacion.text = user.identificacion
            nombre.text = user.nombre
        }
    }

    private suspend fun getUser() {
        val userPost = AuthUser(
            mac = "",
            nomAplicacion = "Controller APP",
            password = "SW50ZXIyMDIx\n",
            path = "",
            usuario = "cGFtLm1lcmVkeTIx\n"
        )
        val userAuth = retrofit.getRetrofit().auth(userPost)

        val resUser = userAuth.body()
        if (userAuth.isSuccessful){
            val users = db.userDao().getAll()
            val user = users.first()
            user.usuario = resUser?.usuario ?: ""
            user.identificacion = resUser?.identificacion ?: ""
            user.nombre = resUser?.nombre ?: ""
            CoroutineScope(Dispatchers.IO).launch { db.userDao().update(user) }
            withContext(Dispatchers.Main){ showInfoUser(user) }
        }else{
            requireContext().showMessageError(userAuth.message())
        }
    }

}