package com.simplephotos.remote.service

import com.simplephotos.remote.models.album.AlbumModel
import com.simplephotos.remote.network.RestApiConstants
import io.reactivex.rxjava3.core.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * @author Mahmoud Gamal on 15/10/2021.
 */
interface AlbumService {

    @GET(RestApiConstants.ALBUMS_API)
    fun getAlbumsByUserId(@Query(RestApiConstants.USER_ID_PARAMS) userId: Int): Observable<List<AlbumModel>>
}