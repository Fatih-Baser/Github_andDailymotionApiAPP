package com.edushare.lsizadanie.module

import android.content.Context
import androidx.room.Room
import com.edushare.lsizadanie.room.LocalDB
import com.edushare.lsizadanie.room.UsersDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.ViewModelScoped


@Module
@InstallIn(ViewModelComponent::class)
class DatabaseModule {

    @Provides
    @ViewModelScoped
    fun provideLocalDB(@ApplicationContext appContext: Context): LocalDB =
        Room.databaseBuilder(
            appContext,
            LocalDB::class.java,
            "local.db"
        ).build()

    @Provides
    @ViewModelScoped
    fun provideDao(localDB: LocalDB): UsersDao {
        return localDB.usersDao()
    }
}