package com.edushare.lsizadanie.repository

import androidx.lifecycle.LiveData
import com.edushare.lsizadanie.model.User

interface UsersLocalRepository {
    fun getUsers(): LiveData<List<User>?>
}