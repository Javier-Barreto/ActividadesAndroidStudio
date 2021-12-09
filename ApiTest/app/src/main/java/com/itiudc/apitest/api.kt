package com.itiudc.apitest

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

var api =
    Retrofit
        .Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://www.breakingbadapi.com/api/")
        .build()