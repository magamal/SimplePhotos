package com.simplephotos.data.repository.user

import com.simplephotos.data.models.user.UserEntity
import io.reactivex.rxjava3.core.Observable

/**
 * @author Mahmoud Gamal on 15/10/2021.
 */
interface UserDataStore {
    fun getUserById(userId: Int): Observable<UserEntity>
}