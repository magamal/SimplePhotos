package com.simplephotos.data

import com.simplephotos.data.mappers.photo.PhotoEntityMapper
import com.simplephotos.data.store.photo.PhotoDataStoreFactory
import com.simplephotos.domain.models.photos.Photo
import com.simplephotos.domain.repository.PhotosRepository
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

/**
 * @author Mahmoud Gamal on 15/10/2021.
 */
class PhotosDataRepoImp @Inject constructor(
    private val photoDataStoreFactory: PhotoDataStoreFactory,
    private val photosMapper: PhotoEntityMapper
) : PhotosRepository {
    override fun getPhotosByAlbumId(albumId: Int): Observable<List<Photo>> =
        photoDataStoreFactory
            .getRemote()
            .getPhotosByAlbumId(albumId)
            .map { photos ->
                return@map photos.map(photosMapper::mapToDomain)
            }
}