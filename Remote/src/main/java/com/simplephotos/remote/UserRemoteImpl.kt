package com.simplephotos.remote

import com.simplephotos.data.models.user.UserEntity
import com.simplephotos.data.repository.user.UserRemote
import com.simplephotos.remote.mappers.user.UserModelMapper
import com.simplephotos.remote.network.errorhandler.adaptExceptionError
import com.simplephotos.remote.service.UserService
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

/**
 * @author Mahmoud Gamal on 15/10/2021.
 */
class UserRemoteImpl @Inject constructor(
    private val userService: UserService,
    private val userMapper: UserModelMapper
) : UserRemote {
    override fun getUserById(userId: Int): Observable<UserEntity> =
        userService
            .getUserById(userId)
            .map(userMapper::mapFromModel)
            .adaptExceptionError()

}