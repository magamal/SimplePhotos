package com.simplephotos.data

import com.simplephotos.data.mappers.user.UserEntityMapper
import com.simplephotos.data.store.user.UsersDataStoreFactory
import com.simplephotos.domain.models.user.User
import com.simplephotos.domain.repository.UsersRepository
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

/**
 * @author Mahmoud Gamal on 15/10/2021.
 */
class UsersDataRepoImp @Inject constructor(
    private val usersDataStoreFactory: UsersDataStoreFactory,
    private val userMapper: UserEntityMapper
) : UsersRepository {
    override fun getUserById(userId: Int): Observable<User> =
        usersDataStoreFactory
            .getRemote()
            .getUserById(userId)
            .map(userMapper::mapToDomain)
}