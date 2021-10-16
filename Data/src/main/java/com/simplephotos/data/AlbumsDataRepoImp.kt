package com.simplephotos.data

import com.simplephotos.data.mappers.album.AlbumEntityMapper
import com.simplephotos.data.store.album.AlbumDataStoreFactory
import com.simplephotos.domain.models.album.Album
import com.simplephotos.domain.repository.AlbumsRepository
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

/**
 * @author Mahmoud Gamal on 15/10/2021.
 */
class AlbumsDataRepoImp @Inject constructor(
    private val albumDataStoreFactory: AlbumDataStoreFactory,
    private val albumMapper: AlbumEntityMapper
) : AlbumsRepository {
    override fun getAlbumsByUserId(userId: Int): Observable<List<Album>> =
        albumDataStoreFactory
            .getRemote()
            .getAlbumsByUserId(userId)
            .map { albums ->
                return@map albums.map(albumMapper::mapToDomain)
            }
}