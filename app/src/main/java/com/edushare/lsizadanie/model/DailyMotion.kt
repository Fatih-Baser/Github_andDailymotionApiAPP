package com.edushare.lsizadanie.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DailyMotion(
    val list: List<DailyMotionUser>
) {
    @JsonClass(generateAdapter = true)
    data class DailyMotionUser(
        val id: String,
        @Json(name = "screenname") val screenName: String


    )
}


