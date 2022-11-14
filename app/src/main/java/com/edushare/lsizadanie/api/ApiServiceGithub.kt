package com.edushare.lsizadanie.api

import com.edushare.lsizadanie.model.GithubUser
import retrofit2.http.GET

interface ApiServiceGithub {
    @GET("users")
    suspend fun getUsers(): List<GithubUser>
}