package com.example.hw52

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hw52.databinding.FragmentHistoryBinding

@Suppress("UNREACHABLE_CODE")
class HistoryFragment : Fragment() {

    private lateinit var binding: FragmentHistoryBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentHistoryBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val list = App.appDataBase.loveDao().getAllByAlphabet()

        var result = ""


        list.forEach{
            result += "${it.firstName}\n${it.secondName}\n${it.percentage}\n${it.result}\n"
        }

        binding.tvHistory.text = result
    }

}