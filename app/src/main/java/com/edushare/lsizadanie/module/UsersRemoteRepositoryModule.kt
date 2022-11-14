package com.edushare.lsizadanie.module

import com.edushare.lsizadanie.repository.UsersRemoteRepository
import com.edushare.lsizadanie.repository.UsersRemoteRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
abstract class UsersRemoteRepositoryModule {

    @Binds
    @ViewModelScoped
    abstract fun bindUsersRemoteRepository(usersRemoteRepositoryImpl: UsersRemoteRepositoryImpl): UsersRemoteRepository
}