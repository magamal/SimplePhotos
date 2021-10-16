package com.simplephotos.domain.usecase.users

import com.simplephotos.domain.executor.ObservableUseCase
import com.simplephotos.domain.executor.PostExecutionThread
import com.simplephotos.domain.models.user.User
import com.simplephotos.domain.repository.UsersRepository
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

/**
 * @author Mahmoud Gamal on 15/10/2021.
 */
class GetUserByUserIdUseCase @Inject constructor(
    private val usersRepository: UsersRepository,
    schedulerThread: PostExecutionThread
) : ObservableUseCase<User, GetUserByUserIdUseCase.Params>(schedulerThread) {
    override fun buildUseCaseObservable(params: Params?): Observable<User> =
        if (params == null)
            throw IllegalArgumentException("Params can not be null")
        else
            usersRepository.getUserById(params.userId)


    data class Params(val userId: Int) {
        companion object {
            fun createParams(userId: Int) = Params(userId = userId)
        }
    }
}