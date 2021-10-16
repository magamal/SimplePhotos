package com.simplephotos.domain.usecase.albums

import com.simplephotos.domain.executor.ObservableUseCase
import com.simplephotos.domain.executor.PostExecutionThread
import com.simplephotos.domain.models.album.Album
import com.simplephotos.domain.repository.AlbumsRepository
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

/**
 * @author Mahmoud Gamal on 15/10/2021.
 */
class GetAlbumsByUserUseCase @Inject constructor(
    private val albumsRepository: AlbumsRepository,
    schedulerThread: PostExecutionThread
) : ObservableUseCase<List<Album>, GetAlbumsByUserUseCase.Params>(schedulerThread) {
    override fun buildUseCaseObservable(params: Params?): Observable<List<Album>> =
        if (params == null)
            throw IllegalArgumentException("Params can not be null")
        else
            albumsRepository.getAlbumsByUserId(params.userId)


    data class Params(val userId: Int) {
        companion object {
            fun createParams(userId: Int) = Params(userId = userId)
        }
    }
}