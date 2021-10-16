package com.simplephotos.remote.service

import com.simplephotos.remote.models.user.UserModel
import com.simplephotos.remote.network.RestApiConstants
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * @author Mahmoud Gamal on 13/10/2021.
 */
interface UserService {

    @GET(RestApiConstants.USERS_API)
    fun getUsers(): Observable<List<UserModel>>

    @GET(RestApiConstants.USERS_API+"/{${RestApiConstants.USER_ID_PARAMS}}")
    fun getUserById(@Path(RestApiConstants.USER_ID_PARAMS) userId: Int): Observable<UserModel>
}