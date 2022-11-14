package com.edushare.lsizadanie.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserDB(
    @PrimaryKey val id: String,
    val name: String,
    val avatarUrl: String,
    val sourceApi: String
)