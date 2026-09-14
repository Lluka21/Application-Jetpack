package com.example.myapplication.data.remote

import data.model.SignInRequst
import data.model.SignUpRequest
import retrofit2.http.Body
import retrofit2.http.POST


interface AuthApi {
    @POST("auth/signup")
    suspend fun signup(
        @Body request: SignUpRequest
    )

    @POST(value = "auth/signin")
    suspend fun signin(
        @Body request: SignInRequst
    )
}