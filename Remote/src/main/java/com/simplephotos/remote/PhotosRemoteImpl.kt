package com.simplephotos.remote

import com.simplephotos.data.models.photos.PhotoEntity
import com.simplephotos.data.repository.photo.PhotosRemote
import com.simplephotos.remote.mappers.photo.PhotoModelMapper
import com.simplephotos.remote.network.errorhandler.adaptExceptionError
import com.simplephotos.remote.service.PhotoService
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

/**
 * @author Mahmoud Gamal on 15/10/2021.
 */
class PhotosRemoteImpl @Inject constructor(
    private val photoService: PhotoService,
    private val photoMapper: PhotoModelMapper
) : PhotosRemote {
    override fun getPhotosByAlbumId(albumId: Int): Observable<List<PhotoEntity>> =
        photoService
            .getAlbumsByUserId(albumId)
            .map { photos ->
                photos.map(photoMapper::mapFromModel)
            }
            .adaptExceptionError()
}