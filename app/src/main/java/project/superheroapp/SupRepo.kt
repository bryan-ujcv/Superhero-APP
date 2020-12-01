package project.superheroapp

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SupRepo (private val supService:APIservice){
    fun listarSuper(callback: (List<SupResponse.Superhero>?)->Unit){
        val supCall = supService.listarSuper()
        supCall.enqueue(object: Callback<SupResponse> {
            override fun onResponse(call: Call<SupResponse>, response: Response<SupResponse>){
                val body = response?.body()
                callback(body?.results)
            }
            override fun onFailure(call: Call<SupResponse>,t:Throwable){
                callback(null)
            }
        })
    }
}