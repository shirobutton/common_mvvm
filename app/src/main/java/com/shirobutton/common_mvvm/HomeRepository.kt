package com.shirobutton.common_mvvm

class HomeRepository {
     suspend fun getImageUrl() = kotlin.runCatching {
          ApiClient.randomCatApi.getRandomCat().file
     }
}
