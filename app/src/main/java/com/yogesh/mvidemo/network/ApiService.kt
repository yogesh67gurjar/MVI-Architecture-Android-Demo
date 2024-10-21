package com.yogesh.mvidemo.network

import com.yogesh.mvidemo.model.CatFactResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("fact")
    fun getFact(): Call<CatFactResponse>
}