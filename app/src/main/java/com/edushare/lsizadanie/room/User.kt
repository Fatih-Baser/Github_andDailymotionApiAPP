package com.edushare.lsizadanie.room

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val id: String,
    val name: String,
    val avatarUrl: String,
    val sourceApi: String
) : Parcelable