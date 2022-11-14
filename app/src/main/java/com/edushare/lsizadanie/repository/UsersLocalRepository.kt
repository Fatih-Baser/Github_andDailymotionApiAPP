package com.edushare.lsizadanie.repository

import androidx.lifecycle.LiveData
import com.edushare.lsizadanie.room.User

interface UsersLocalRepository {
    fun getUsers(): LiveData<List<User>?>
}