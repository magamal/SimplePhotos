package com.simplephotos.remote

import com.simplephotos.data.models.album.AlbumEntity
import com.simplephotos.data.repository.album.AlbumsRemote
import com.simplephotos.remote.mappers.album.AlbumModelMapper
import com.simplephotos.remote.network.errorhandler.adaptExceptionError
import com.simplephotos.remote.service.AlbumService
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

/**
 * @author Mahmoud Gamal on 15/10/2021.
 */
class AlbumsRemoteImpl @Inject constructor(
    private val albumService: AlbumService,
    private val albumMapper: AlbumModelMapper
) : AlbumsRemote {

    override fun getAlbumsByUserId(userId: Int): Observable<List<AlbumEntity>> =
        albumService
            .getAlbumsByUserId(userId)
            .map { Albums ->
                Albums.map(albumMapper::mapFromModel)
            }
            .adaptExceptionError()

}