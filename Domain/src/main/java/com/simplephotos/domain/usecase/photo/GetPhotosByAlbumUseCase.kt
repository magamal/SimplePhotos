package com.simplephotos.domain.usecase.photo

import com.simplephotos.domain.executor.ObservableUseCase
import com.simplephotos.domain.executor.PostExecutionThread
import com.simplephotos.domain.models.photos.Photo
import com.simplephotos.domain.repository.PhotosRepository
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

/**
 * @author Mahmoud Gamal on 15/10/2021.
 */
class GetPhotosByAlbumUseCase @Inject constructor(
    private val photosRepository: PhotosRepository,
    schedulerThread: PostExecutionThread
) : ObservableUseCase<List<Photo>, GetPhotosByAlbumUseCase.Params>(schedulerThread) {
    override fun buildUseCaseObservable(params: Params?): Observable<List<Photo>> =
        if (params == null)
            throw IllegalArgumentException("Params can not be null")
        else
            photosRepository.getPhotosByAlbumId(params.albumId)


    data class Params(val albumId: Int) {
        companion object {
            fun createParams(albumId: Int) = Params(albumId = albumId)
        }
    }
}