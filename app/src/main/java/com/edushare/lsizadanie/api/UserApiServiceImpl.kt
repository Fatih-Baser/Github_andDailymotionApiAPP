package com.edushare.lsizadanie.api



import com.edushare.lsizadanie.other.Constants.BASE_URL_DAILMOTION
import com.edushare.lsizadanie.other.Constants.BASE_URL_GITHUB
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory



private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofitDailymotion = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL_DAILMOTION)
    .build()

private val retrofitGithub = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL_GITHUB)
    .build()




object UsersApi {
    val retrofitDailymotionApiService: ApiServiceDailyMotion by lazy {
        retrofitDailymotion.create(ApiServiceDailyMotion::class.java)
    }

    val retrofitGithubApiService: ApiServiceGithub by lazy {
        retrofitGithub.create(ApiServiceGithub::class.java)
    }
}

