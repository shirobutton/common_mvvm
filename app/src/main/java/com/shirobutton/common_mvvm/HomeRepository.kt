package com.shirobutton.common_mvvm

class HomeRepository {
     suspend fun getImageUrl() = ApiClient.randomCatApi.getRandomCat().file
}
