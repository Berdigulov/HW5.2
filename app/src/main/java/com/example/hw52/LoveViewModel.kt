package com.example.hw52

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.hw52.love.LoveModel

class LoveViewModel:ViewModel() {

    val repository = Repository()

    fun liveModel(firstName:String,secondName:String):LiveData<LoveModel>{
        return repository.getLiveLoveModel(firstName,secondName)
    }

}