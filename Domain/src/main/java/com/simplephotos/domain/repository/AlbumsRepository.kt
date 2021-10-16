package com.simplephotos.domain.repository

import com.simplephotos.domain.models.album.Album
import io.reactivex.rxjava3.core.Observable

/**
 * @author Mahmoud Gamal on 15/10/2021.
 */
interface AlbumsRepository {
    fun getAlbumsByUserId(userId: Int): Observable<List<Album>>
}