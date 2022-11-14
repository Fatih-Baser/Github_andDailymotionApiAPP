package com.edushare.lsizadanie.module

import com.edushare.lsizadanie.api.ApiServiceDailyMotion
import com.edushare.lsizadanie.api.ApiServiceGithub
import com.edushare.lsizadanie.api.UsersApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object ApisModule {

    @Provides
    fun providesDailymotionApiService(): ApiServiceDailyMotion = UsersApi.retrofitDailymotionApiService

    @Provides
    fun provideGithubApiService(): ApiServiceGithub = UsersApi.retrofitGithubApiService
}