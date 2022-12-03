package com.example.hw52

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.hw52.databinding.FragmentResultBinding
import com.example.hw52.love.LoveFragment
import com.example.hw52.love.LoveModel


class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentResultBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getResult()
        binding.btnHistory.setOnClickListener {
            findNavController().navigate(R.id.historyFragment)
        }
    }


    fun getResult(){
        with(binding){
            val all:LoveModel = arguments?.getSerializable(LoveFragment.KEY_FOR_ALL) as LoveModel
            tvFname.text = all.firstName
            tvSname.text = all.secondName
            tvPercent.text = all.percentage
            tvResult.text = all.result
        }

    }

}