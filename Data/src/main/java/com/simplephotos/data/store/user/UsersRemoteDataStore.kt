package com.simplephotos.data.store.user

import com.simplephotos.data.models.user.UserEntity
import com.simplephotos.data.repository.user.UserDataStore
import com.simplephotos.data.repository.user.UserRemote
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

/**
 * @author Mahmoud Gamal on 15/10/2021.
 */
class UsersRemoteDataStore @Inject constructor(
    private val userRemote: UserRemote
) : UserDataStore {
    override fun getUserById(userId: Int): Observable<UserEntity> = userRemote.getUserById(userId)
}