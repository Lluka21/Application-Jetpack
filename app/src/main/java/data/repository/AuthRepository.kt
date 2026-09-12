package com.example.myapplication.data.repository


import com.example.myapplication.data.remote.AuthApi
import data.model.SignUpRequest



class AuthRepository(
    private val authApi: AuthApi
) {
    suspend fun signup(request: SignUpRequest) {
        authApi.signup(request);
    }
}
