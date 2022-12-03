package com.example.hw52.love

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.example.hw52.App
import com.example.hw52.R
import com.example.hw52.databinding.FragmentLoveBinding
import com.example.hw52.room.AppDataBase


class LoveFragment : Fragment() {

    private lateinit var binding: FragmentLoveBinding
    private val viewModel:LoveViewModel by viewModels({ requireActivity() })

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentLoveBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickers()
    }

    private fun initClickers(){
        with(binding){
            btnCalculate.setOnClickListener {
                viewModel.liveModel(firstEt.text.toString(),secondEt.text.toString()).observe(
                    requireActivity(),
                    Observer{ model ->
                        App.appDataBase.loveDao().insert(model)
                        val all = model
                        val bundle = Bundle()
                        bundle.putSerializable(KEY_FOR_ALL, all)
                        findNavController().navigate(R.id.resultFragment,bundle)
                    })

            }
        }
    }

    companion object{
        const val KEY_FOR_ALL = "key_all"
    }

}