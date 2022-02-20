package com.shirobutton.common_mvvm

class HomeRepository (private val randomCatApi: RandomCatApi) {
     suspend fun getImageUrl() = kotlin.runCatching {
          randomCatApi.getRandomCat().file
     }
}
