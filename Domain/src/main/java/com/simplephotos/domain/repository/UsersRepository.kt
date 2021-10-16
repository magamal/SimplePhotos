package com.simplephotos.domain.repository

import com.simplephotos.domain.models.user.User
import io.reactivex.rxjava3.core.Observable

/**
 * @author Mahmoud Gamal on 15/10/2021.
 */
interface UsersRepository {
    fun getUserById(userId: Int): Observable<User>
}