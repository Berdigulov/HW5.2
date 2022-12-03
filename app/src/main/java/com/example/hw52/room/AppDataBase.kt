package com.example.hw52.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.hw52.love.LoveModel

@Database(entities = [LoveModel::class], version = 1)
abstract class AppDataBase: RoomDatabase() {

    abstract fun loveDao():LoveDao

}