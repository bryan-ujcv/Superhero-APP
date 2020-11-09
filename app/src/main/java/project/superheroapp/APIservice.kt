package com.app.superheroapp2

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface APIservice {
    @GET
    fun getCharacterByName(@Url url:String): Call<SupResponse>
}