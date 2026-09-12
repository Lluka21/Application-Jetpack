package com.example.myapplication.data.remote

import data.model.SignUpRequest
import retrofit2.http.Body
import retrofit2.http.POST


interface AuthApi {

    @POST("auth/signup")
    suspend fun signup(
        @Body request: SignUpRequest
    )
}