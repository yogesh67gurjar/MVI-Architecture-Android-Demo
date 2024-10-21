package com.yogesh.mvidemo.ui.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.yogesh.mvidemo.model.CatFactResponse
import com.yogesh.mvidemo.network.ApiService
import com.yogesh.mvidemo.ui.intents.MainIntents
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModel : ViewModel() {
    private val apiService: ApiService = Retrofit.Builder().baseUrl("https://catfact.ninja/")
        .addConverterFactory(GsonConverterFactory.create()).build().create(ApiService::class.java)

    private var _catFactSuccess: MutableLiveData<CatFactResponse> = MutableLiveData()
    var catFactSuccess: LiveData<CatFactResponse> = _catFactSuccess

    private var _catFactFailure: MutableLiveData<String> = MutableLiveData()
    var catFactFailure: LiveData<String> = _catFactFailure

    fun fireIntent(intent: MainIntents) {
        when (intent) {
            MainIntents.GetFact -> {
                getFact()
            }
        }
    }

    private fun getFact() {
        apiService.getFact().enqueue(object : Callback<CatFactResponse> {
            override fun onResponse(
                call: Call<CatFactResponse>,
                response: Response<CatFactResponse>
            ) {
                if (response.isSuccessful) {
                    _catFactSuccess.postValue(response.body())
                } else {
                    _catFactFailure.postValue(response.message())
                }
            }

            override fun onFailure(call: Call<CatFactResponse>, t: Throwable) {
                _catFactFailure.postValue(t.message.toString())
            }
        })
    }
}