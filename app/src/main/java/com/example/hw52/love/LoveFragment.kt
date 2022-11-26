package com.example.hw52.love

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.findNavController
import com.example.hw52.App
import com.example.hw52.LoveViewModel
import com.example.hw52.R
import com.example.hw52.databinding.FragmentLoveBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoveFragment : Fragment() {

    private lateinit var binding: FragmentLoveBinding
    val viewModel:LoveViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
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
                viewModel.liveModel(firstEt.text.toString(),secondEt.text.toString()).observe(viewLifecycleOwner,
                    Observer {
                        val all = it
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