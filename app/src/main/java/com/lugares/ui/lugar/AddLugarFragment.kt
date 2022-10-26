package com.lugares.ui.lugar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.lugares.databinding.FragmentAddLugarBinding
import com.lugares.viewmodel.LugarViewModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AddLugarFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddLugarFragment : Fragment() {
    private var binding: FragmentAddLugarBinding? = null
    private val binding get() = binding!!
    private lateinit var lugarViewModel: LugarViewModel
    //Agregar variable mediante lateinit lo que logra es una inicializacion tardia,
    //indicando al compilador que dicha inicializacion se realizara mas adelante en el codigo
    //Si intentamos acceder a alguna variable antes de su iniacilizacion obtendremos un error del tipo Caused by

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        lugarViewModel =
                ViewModelProvider(this)[LugarViewModel::class.java]
        binding = FragmentAddLugarBinding.inflate(inflater, container, false)
        return binding.root

    }
}