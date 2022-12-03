package com.example.hw52

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.hw52.love.LoveAPI
import com.example.hw52.love.LoveModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val api: LoveAPI) {

    fun getLiveLoveModel(firstName:String,secondName:String):MutableLiveData<LoveModel>{
        var liveModel = MutableLiveData<LoveModel>()
        api.calculateLove(firstName,secondName).enqueue(object :Callback<LoveModel>{
            override fun onResponse(call: Call<LoveModel>, response: Response<LoveModel>) {
                if(response.isSuccessful){
                    liveModel.postValue(response.body())
                }
            }

            override fun onFailure(call: Call<LoveModel>, t: Throwable) {
                Log.e("ololo", "onFailure: ${t.message}", )
            }

        })
        return  liveModel
    }
}