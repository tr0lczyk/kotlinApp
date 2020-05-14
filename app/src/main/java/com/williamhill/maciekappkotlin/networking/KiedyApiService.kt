package com.williamhill.maciekappkotlin.networking

import com.williamhill.maciekappkotlin.model.DataObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers

interface KiedyApiService {

    @GET("examples")
    @Headers("Accept: application/json")
    fun getExamples(): Call<DataObject>
}