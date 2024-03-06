package com.example.tasksmanager.data.https

import com.example.tasksmanager.domain.entities.ResponseGemini
import com.example.tasksmanager.domain.entities.RetrofitRequest
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface RetrofitService {
    @POST("v1beta/models/gemini-pro:generateContent?key=AIzaSyDb99xzctJctcem4G5iP4qcW7Me3NAgJSM")
    suspend fun getMessage(
     @Body  request: RetrofitRequest
    ) : ResponseGemini
}

object RetrofitServiceFactory{
    fun makeRetrofitService():RetrofitService{
        return Retrofit.Builder()
            .baseUrl("https://generativelanguage.googleapis.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(RetrofitService::class.java)
    }
}