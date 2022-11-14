package com.edushare.lsizadanie.api



import com.edushare.lsizadanie.model.DailyMotion
import retrofit2.http.GET

interface ApiServiceDailyMotion {

    @GET("users")
    suspend fun getUsers(): DailyMotion

}