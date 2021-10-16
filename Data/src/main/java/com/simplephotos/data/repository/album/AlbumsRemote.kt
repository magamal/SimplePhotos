package com.simplephotos.data.repository.album

import com.simplephotos.data.models.album.AlbumEntity
import io.reactivex.rxjava3.core.Observable

/**
 * Created by Mahmoud Gamal on 2019-09-06.
 */
interface AlbumsRemote {
    fun getAlbumsByUserId(userId: Int): Observable<List<AlbumEntity>>
}