package com.simplephotos.data.store.album

import com.simplephotos.data.models.album.AlbumEntity
import com.simplephotos.data.repository.album.AlbumsDataStore
import com.simplephotos.data.repository.album.AlbumsRemote
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

/**
 * @author Mahmoud Gamal on 15/10/2021.
 */
class AlbumRemoteDataStore @Inject constructor(
    private val albumsRemote: AlbumsRemote
) : AlbumsDataStore {
    override fun getAlbumsByUserId(userId: Int): Observable<List<AlbumEntity>> =
        albumsRemote.getAlbumsByUserId(userId)
}