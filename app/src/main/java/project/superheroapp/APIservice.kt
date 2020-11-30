package project.superheroapp

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url

interface APIservice {
    @GET("superhero")
    fun listarSuper(): Call<SupResponse>

    companion object{
        val instance:APIservice by lazy {
            val retrofit =Retrofit.Builder()
                .baseUrl("https://superheroapi.com/api/3539424979434165/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            retrofit.create(APIservice::class.java)
        }
    }
}