package com.edushare.lsizadanie.repository

import androidx.lifecycle.Transformations
import com.edushare.lsizadanie.room.User
import com.edushare.lsizadanie.room.UsersDao

import javax.inject.Inject

class UsersLocalRepositoryImpl @Inject constructor(
    private val usersDao: UsersDao,
) : UsersLocalRepository {

    override fun getUsers() = Transformations.map(usersDao.getUsers()) { list ->
        list?.map { userDB ->
            userDB.run {
                User(id, name, avatarUrl, sourceApi)
            }
        }
    }
}