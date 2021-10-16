package com.simplephotos.data.store.album

import com.simplephotos.data.repository.album.AlbumsDataStore
import javax.inject.Inject

/**
 * @author Mahmoud Gamal on 15/10/2021.
 */
class AlbumDataStoreFactory @Inject constructor(
    private val albumRemoteDataStore: AlbumRemoteDataStore
) {
    fun getRemote(): AlbumsDataStore = albumRemoteDataStore
}