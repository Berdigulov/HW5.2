package com.example.hw52

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.hw52.love.LoveAPI
import com.example.hw52.room.AppDataBase
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App:Application(){
    companion object{
        lateinit var appDataBase: AppDataBase
    }

    override fun onCreate() {
        super.onCreate()
        appDataBase = Room.databaseBuilder(applicationContext,AppDataBase::class.java,"love").
        allowMainThreadQueries().build()
    }
}