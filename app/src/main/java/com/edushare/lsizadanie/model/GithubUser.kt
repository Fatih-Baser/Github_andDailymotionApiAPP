package com.edushare.lsizadanie.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GithubUser(
    val id: Int,
    @Json(name = "login") val userName: String,
    @Json(name = "avatar_url") val avatarUrl: String
)