package com.partners.hostpital.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object API {
    val url = "https://083f20d8.ngrok.io"
    fun request(): ApiHostpital{
        val retrofit = Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(url).build()
        return retrofit.create(ApiHostpital::class.java)
    }


}
