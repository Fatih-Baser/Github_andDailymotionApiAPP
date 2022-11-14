package com.edushare.lsizadanie.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UsersDao {

    @Query("DELETE FROM UserDB")
    suspend fun deleteAll()

    @Query("SELECT * FROM UserDB")
    fun getUsers(): LiveData<List<UserDB>?>

    @Insert
    suspend fun insert(users: List<UserDB>)
}