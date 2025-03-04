package com.diose.pruebatecnica_interrapidisimo.view

import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.diose.pruebatecnica_interrapidisimo.R
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
        //verificar si el usuario esta en la base de datos
        if (user.usuario.isEmpty() || user.identificacion.isEmpty() || user.nombre.isEmpty()){
            retrofit = Retrofit()
            CoroutineScope(Dispatchers.IO).launch {
                getUser()
            }
        }else{
            showInfoUser(user)
        }

        val textoCompleto = "Interrapidisimo"
        val spannableString = SpannableString(textoCompleto)
        spannableString.setSpan(ForegroundColorSpan(ContextCompat.getColor(requireContext(), android.R.color.holo_orange_dark)),0, 5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        spannableString.setSpan(ForegroundColorSpan(ContextCompat.getColor(requireContext(), R.color.black)),5, textoCompleto.length, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE)
        binding.inter.text = spannableString

        binding.tables.setOnClickListener { changeFragment(SchemaFragment()) }

        binding.localities.setOnClickListener { changeFragment(LocalitiesFragment()) }
    }

    private fun changeFragment(fragment: Fragment){
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .addToBackStack("fragment")
            .commit()
    }

    private fun showInfoUser(user: User) {
        //mostrar los datos del usuario
        binding.apply {
            usuario.text = user.usuario
            identificacion.text = user.identificacion
            nombre.text = user.nombre
        }
    }

    private suspend fun getUser() {
        //obtener los datos del usuario de web
        val userPost = AuthUser(
            mac = "",
            nomAplicacion = "Controller APP",
            password = "SW50ZXIyMDIx\n",
            path = "",
            usuario = "cGFtLm1lcmVkeTIx\n"
        )

        try {
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
                withContext(Dispatchers.Main){ requireContext().showMessageError(userAuth.errorBody()?.charStream()!!.readText()){}}
            }
        }catch (e: Exception){
            withContext(Dispatchers.Main){ requireContext().showMessageError(e.message.toString()){this@UserFragment.requireActivity().finish()}}
        }
    }

}