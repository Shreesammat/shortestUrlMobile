package com.example.shortest1.network

import retrofit2.http.Body
import retrofit2.http.POST

interface retrofitapi {
    @POST("shorten")
    suspend fun shortenUrl(@Body request: UrlRequest): UrlResponse
}