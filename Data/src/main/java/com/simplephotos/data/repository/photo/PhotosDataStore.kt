package com.simplephotos.data.repository.photo

import com.simplephotos.data.models.photos.PhotoEntity
import io.reactivex.rxjava3.core.Observable

/**
 * @author Mahmoud Gamal on 15/10/2021.
 */
interface PhotosDataStore {
    fun getPhotosByAlbumId(albumId: Int): Observable<List<PhotoEntity>>
}