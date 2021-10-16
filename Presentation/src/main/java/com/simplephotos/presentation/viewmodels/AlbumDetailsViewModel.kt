package com.simplephotos.presentation.viewmodels

import androidx.lifecycle.LifecycleOwner
import com.simplephotos.domain.models.photos.Photo
import com.simplephotos.domain.usecase.photo.GetPhotosByAlbumUseCase
import com.simplephotos.presentation.base.BaseViewModel
import com.simplephotos.presentation.base.MutableListLiveData
import com.simplephotos.presentation.base.Resource
import com.simplephotos.presentation.mapper.photo.PhotoViewMapper
import com.simplephotos.presentation.models.photos.PhotoView
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.kotlin.subscribeBy
import javax.inject.Inject

/**
 * @author Mahmoud Gamal on 16/10/2021.
 */
@HiltViewModel
class AlbumDetailsViewModel @Inject constructor(
    private val getPhotosByAlbumUseCase: GetPhotosByAlbumUseCase,
    private val photoMapper: PhotoViewMapper
) : BaseViewModel() {

    private val photosLiveData = MutableListLiveData<PhotoView>()


    fun observeOnPhotos(
        owner: LifecycleOwner,
        onLoading: () -> Unit,
        onError: (Throwable?) -> Unit,
        onNewData: (List<PhotoView>, List<PhotoView>) -> Unit
    ) = photosLiveData.observe(
        owner = owner,
        onLoading = onLoading,
        onError = onError,
        onNewData = onNewData
    )

    fun getPhotos(albumId: Int) {
        photosLiveData.loading()
        addDisposale(
            createObservableForPhotos(albumId)
                .subscribeBy(
                    onNext = { photos ->
                        photosLiveData.setItems(photos.map(photoMapper::mapToPresentation))
                    },
                    onError = { throwable ->
                        throwable.printStackTrace()
                        photosLiveData.error(throwable)
                    }
                )
        )
    }

    private fun createObservableForPhotos(albumId: Int): Observable<List<Photo>> =
        getPhotosByAlbumUseCase
            .getObservable(GetPhotosByAlbumUseCase.Params.createParams(albumId))

    fun getFilteredPhotos(text: String?): List<PhotoView> =
        if (text.isNullOrEmpty() || photosLiveData.value?.state != Resource.State.SUCCESS)
            emptyList()
        else photosLiveData.value?.values?.second?.filter { photo -> photo.title?.contains(text) == true }
            ?: emptyList()

    fun getLastFetchedPhotos(): List<PhotoView> =
        photosLiveData.value?.values?.second ?: emptyList()


}