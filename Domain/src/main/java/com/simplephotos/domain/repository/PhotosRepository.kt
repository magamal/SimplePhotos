package com.simplephotos.domain.repository

import com.simplephotos.domain.models.photos.Photo
import io.reactivex.rxjava3.core.Observable

/**
 * @author Mahmoud Gamal on 15/10/2021.
 */
interface PhotosRepository {
    fun getPhotosByAlbumId(albumId: Int): Observable<List<Photo>>
}