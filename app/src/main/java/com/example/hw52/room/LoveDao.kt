package com.example.hw52.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.hw52.love.LoveModel

@Dao
interface LoveDao {

    @Insert
    fun insert(loveModel: LoveModel)
    @Query("SELECT * FROM love_table")
    fun getAll(): List<LoveModel>
    @Query("SELECT * FROM love_table ORDER BY firstName")
    fun getAllByAlphabet():List<LoveModel>

}