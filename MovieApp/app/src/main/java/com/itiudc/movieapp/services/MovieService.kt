package com.itiudc.movieapp.services

import com.itiudc.movieapp.api.Response
import com.itiudc.movieapp.api.api
import com.itiudc.movieapp.models.Movie
import retrofit2.http.GET

interface MovieService {

    @GET("films")
    //@GET("popular?api_key=9c513f80f346744327518ff873111f0f")
    suspend fun getPopular(): Response<MutableList<Movie>>
}

var movieService: MovieService = api.create<MovieService>(MovieService::class.java)