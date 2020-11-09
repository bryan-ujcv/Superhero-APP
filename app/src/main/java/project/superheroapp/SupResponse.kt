package com.app.superheroapp2

import com.google.gson.annotations.SerializedName

data class SupResponse(@SerializedName("status") var status:String, @SerializedName("message") var image: List<String>)
