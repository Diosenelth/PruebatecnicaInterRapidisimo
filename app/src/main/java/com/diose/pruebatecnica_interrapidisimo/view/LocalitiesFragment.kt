package com.diose.pruebatecnica_interrapidisimo.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.diose.pruebatecnica_interrapidisimo.databinding.FragmentRvBinding
import com.diose.pruebatecnica_interrapidisimo.model.api.Retrofit
import com.diose.pruebatecnica_interrapidisimo.model.database.AppDatabase
import com.diose.pruebatecnica_interrapidisimo.model.database.localities.Localities
import com.diose.pruebatecnica_interrapidisimo.model.showMessageError
import com.diose.pruebatecnica_interrapidisimo.view.adapter.RecyclerViewAdapterLocalities
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class LocalitiesFragment : Fragment() {

    private var _binding : FragmentRvBinding? = null
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
        db = AppDatabase.getInstance(requireContext())
        retrofit = Retrofit()

        val localities = db.localities().getAll()
        if (localities.isEmpty()){
            CoroutineScope(Dispatchers.IO).launch {
                getLocalidades()
            }
        }else{
            showLocalities(localities)
        }
        binding.buttonBack.setOnClickListener { parentFragmentManager.popBackStack() }
    }

    private fun showLocalities(localities: List<Localities>) {
        val adapter = RecyclerViewAdapterLocalities(localities)
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val divider = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.addItemDecoration(divider)
    }

    private suspend fun getLocalidades() {
        try {
            val localidades = retrofit.getRetrofit().getLocalidades()
            val res = localidades.body()
            if (localidades.isSuccessful){

                val listInsert = res?.map {
                    Localities(
                        id = it.idLocalidad!!.toInt(),
                        abreviacionCiudad = it.abreviacionCiudad,
                        nombreCompleto = it.nombreCompleto
                    )
                }
                if (listInsert != null) {
                    db.localities().insertAll(listInsert)
                    withContext(Dispatchers.Main){ showLocalities(listInsert) }
                }
            }else{
                requireContext().showMessageError(localidades.errorBody()?.charStream()!!.readText()){}
            }
        }catch (e:Exception){
            requireContext().showMessageError(e.message.toString()){this@LocalitiesFragment.requireActivity().finish()}
        }
    }

}