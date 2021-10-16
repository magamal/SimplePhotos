package com.simplephotos.data.store.photo

import com.simplephotos.data.repository.photo.PhotosDataStore
import javax.inject.Inject

/**
 * @author Mahmoud Gamal on 15/10/2021.
 */
class PhotoDataStoreFactory @Inject constructor(
    private val photosRemote: PhotosRemoteDataStore
) {
    fun getRemote(): PhotosDataStore = photosRemote
}