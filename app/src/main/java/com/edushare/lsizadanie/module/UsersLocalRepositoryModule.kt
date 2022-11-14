package com.edushare.lsizadanie.module

import com.edushare.lsizadanie.repository.UsersLocalRepository
import com.edushare.lsizadanie.repository.UsersLocalRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


@Module
@InstallIn(ViewModelComponent::class)
abstract class UsersLocalRepositoryModule {

    @Binds
    @ViewModelScoped
    abstract fun bindUsersLocalRepository(usersLocalRepositoryImpl: UsersLocalRepositoryImpl): UsersLocalRepository
}