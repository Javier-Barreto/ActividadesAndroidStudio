package com.itiudc.movieapp.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

var  api =
    Retrofit
        .Builder()
        .baseUrl("https://ghibliapi.herokuapp.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()