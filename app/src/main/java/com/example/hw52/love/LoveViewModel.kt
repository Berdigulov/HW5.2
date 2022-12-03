package com.example.hw52.love

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.hw52.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoveViewModel @Inject constructor(private val repository: Repository) :ViewModel() {



    fun liveModel(firstName:String,secondName:String):LiveData<LoveModel>{
        return repository.getLiveLoveModel(firstName,secondName)
    }

}