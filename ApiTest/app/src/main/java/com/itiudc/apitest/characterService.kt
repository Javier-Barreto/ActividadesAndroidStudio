package com.itiudc.apitest

import retrofit2.http.GET

interface Character{
    @GET("characters")
    suspend fun getCharacters(): Response<MutableList<character>>
}

var characterS: Character = api.create<Character>(Character::class.java)