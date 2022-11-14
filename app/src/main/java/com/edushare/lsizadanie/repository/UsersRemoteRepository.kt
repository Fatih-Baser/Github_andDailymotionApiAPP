package com.edushare.lsizadanie.repository

import androidx.lifecycle.LiveData

interface UsersRemoteRepository {

    val error: LiveData<Boolean?>
    val errorInfoId: LiveData<Int?>
    val errorText: LiveData<String?>

    suspend fun refresh()
}