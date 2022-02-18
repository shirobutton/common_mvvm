package com.shirobutton.common_mvvm

import retrofit2.http.GET

interface RandomCatApi {
    @GET("meow")
    suspend fun getRandomCat(): RandomCatResponse
}