package com.laioffer.spotify.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {
    private const val BASE_URL = "http://10.0.2.2:8080/"

    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient())
            .build()
    }
}

// static class{} no static word in Kotlin, ===> object do the same thing
//https://kotlinlang.org/docs/object-declarations.html#object-declarations-overview