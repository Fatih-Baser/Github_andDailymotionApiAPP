package com.edushare.lsizadanie.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.edushare.lsizadanie.R
import com.edushare.lsizadanie.api.ApiServiceDailyMotion
import com.edushare.lsizadanie.api.ApiServiceGithub
import com.edushare.lsizadanie.model.DailyMotion


import com.edushare.lsizadanie.model.GithubUser
import com.edushare.lsizadanie.room.UserDB
import com.edushare.lsizadanie.room.UsersDao
import javax.inject.Inject

class UsersRemoteRepositoryImpl
@Inject constructor(private var dao: UsersDao) :
    UsersRemoteRepository {

    @Inject
    lateinit var dailymotionApiService: ApiServiceDailyMotion

    @Inject
    lateinit var githubApiService: ApiServiceGithub

    private val _error = MutableLiveData<Boolean?>()
    override val error: LiveData<Boolean?>
        get() = _error

    private val _errorInfoId = MutableLiveData<Int?>()
    override val errorInfoId: LiveData<Int?>
        get() = _errorInfoId

    private val _errorText = MutableLiveData<String?>()
    override val errorText: LiveData<String?>
        get() = _errorText

    override suspend fun refresh() {
        _error.postValue(null)
        _errorInfoId.postValue(null)
        _errorText.postValue(null)

        try {
            dao.deleteAll()

            githubApiService.getUsers()
                .map {
                    it.asDbModel()
                }.let {
                    dao.insert(it)
                }

            dailymotionApiService.getUsers()
                .asDbModel()
                .let {
                    dao.insert(it)
                }

        } catch (e: Exception) {
            _errorInfoId.postValue(1)
            _errorText.postValue(e.localizedMessage ?: "")
            _error.postValue(true)
        }
    }
}

private fun DailyMotion.asDbModel() =
    list.map { userDTO ->
        UserDB(
            userDTO.id,
            userDTO.screenName,
           "https://user-images.githubusercontent.com/59232580/201677439-72cad5a2-f4d5-48b9-ba3f-ebfb61bf1849.png"
            ,
            "Dailymotion"
        )
    }

private fun GithubUser.asDbModel() =
    UserDB(
        id.toString(),
        userName,
        avatarUrl,
        "GitHub"
    )