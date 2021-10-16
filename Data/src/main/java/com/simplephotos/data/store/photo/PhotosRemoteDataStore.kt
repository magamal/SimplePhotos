package com.simplephotos.data.store.photo

import com.simplephotos.data.models.photos.PhotoEntity
import com.simplephotos.data.repository.photo.PhotosDataStore
import com.simplephotos.data.repository.photo.PhotosRemote
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

/**
 * @author Mahmoud Gamal on 15/10/2021.
 */
class PhotosRemoteDataStore @Inject constructor(
    private val photosRemote: PhotosRemote
) : PhotosDataStore {
    override fun getPhotosByAlbumId(albumId: Int): Observable<List<PhotoEntity>> =
        photosRemote.getPhotosByAlbumId(albumId)
}