package com.example.hw52.di
import com.example.hw52.love.LoveAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(SingletonComponent::class)
@Module
class AppModule {
    @Provides
    fun provideApi(): LoveAPI{
        return Retrofit.Builder().baseUrl("https://love-calculator.p.rapidapi.com/").
        addConverterFactory(GsonConverterFactory.create()).build().create(LoveAPI::class.java)
    }

}