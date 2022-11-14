package com.edushare.lsizadanie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.edushare.lsizadanie.repository.UsersLocalRepository
import com.edushare.lsizadanie.repository.UsersRemoteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class FeedFragmentViewModel @Inject constructor(
    usersRemoteRepository: UsersRemoteRepository,
    usersLocalRepository: UsersLocalRepository
) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            usersRemoteRepository.refresh()
        }
    }

    val usersList = usersLocalRepository.getUsers()
}