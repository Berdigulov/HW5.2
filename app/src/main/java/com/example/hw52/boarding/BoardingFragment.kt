package com.example.hw52.boarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.hw52.R
import com.example.hw52.databinding.FragmentBoardingBinding


class BoardingFragment : Fragment() {

    private lateinit var binding: FragmentBoardingBinding
    private var titles = ArrayList<OnBoard>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = FragmentBoardingBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadBoard()
        val adapter = BoardingAdapter(titles, this::onClick)
        binding.viewpager.adapter = adapter
        binding.wormDotsIndicator.attachTo(binding.viewpager)
    }

    private fun loadBoard(){
        titles.add(OnBoard("Have a good time","You should the time to help those \nwho need you",
            R.drawable.ic_first))
        titles.add(OnBoard("Cherishing Love","It is now no longer possible for \nyou to cherish love",
            R.drawable.ic_second))
        titles.add(OnBoard("Have a breakup?","We have made the correction for you \ndon't worry \nMaybe someone is waiting for you",
            R.drawable.ic_third))
    }

    private fun onClick(){
        findNavController().navigate(R.id.loveFragment)
    }


}