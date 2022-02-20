package com.shirobutton.common_mvvm

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule  {
    @Provides
    fun provideHomeRepository(randomCatApi: RandomCatApi) = HomeRepository(randomCatApi)
}