package com.example.memeapp.networking

import com.example.memeapp.data.Memes
import retrofit2.Response
import retrofit2.http.GET

interface MemesService {

    @GET("/gimme")
    suspend fun getMemes(

    ): Response<Memes>


}