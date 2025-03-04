package com.diose.pruebatecnica_interrapidisimo.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.diose.pruebatecnica_interrapidisimo.databinding.FragmentRvBinding
import com.diose.pruebatecnica_interrapidisimo.model.api.Retrofit
import com.diose.pruebatecnica_interrapidisimo.model.database.AppDatabase
import com.diose.pruebatecnica_interrapidisimo.model.showMessageError
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SchemaFragment : Fragment() {

    private var _binding: FragmentRvBinding? = null
    private val binding get() = _binding!!

    private lateinit var retrofit: Retrofit
    private lateinit var db: AppDatabase

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentRvBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //base de datos
        db = AppDatabase.getInstance(requireContext())
        retrofit = Retrofit()

        CoroutineScope(Dispatchers.IO).launch {
            getTablas()
        }

        binding.buttonBack.setOnClickListener { parentFragmentManager.popBackStack() }
    }

    private suspend fun getTablas() {
        try {
            val tablas = retrofit.getRetrofit().getTablas()
            val res = tablas.body()
            if (tablas.isSuccessful){
                //falta implementar
            }else{
                withContext(Dispatchers.Main){ requireContext().showMessageError(tablas.errorBody()?.charStream()!!.readText()){}}
            }
        }catch (e:Exception){
            withContext(Dispatchers.Main){ requireContext().showMessageError(e.message.toString()){this@SchemaFragment.requireActivity().finish()}}
        }
    }

}