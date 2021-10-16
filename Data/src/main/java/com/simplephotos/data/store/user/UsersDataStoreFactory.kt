package com.simplephotos.data.store.user

import com.simplephotos.data.repository.user.UserDataStore
import javax.inject.Inject

/**
 * @author Mahmoud Gamal on 15/10/2021.
 */
class UsersDataStoreFactory @Inject constructor(
    private val usersRemoteDataStore: UsersRemoteDataStore
) {
    fun getRemote(): UserDataStore = usersRemoteDataStore
}