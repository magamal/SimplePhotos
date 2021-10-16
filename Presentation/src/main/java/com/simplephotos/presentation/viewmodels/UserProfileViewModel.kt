package com.simplephotos.presentation.viewmodels

import androidx.lifecycle.LifecycleOwner
import com.magamal.common.GlobalConstants
import com.simplephotos.domain.models.album.Album
import com.simplephotos.domain.models.user.User
import com.simplephotos.domain.usecase.albums.GetAlbumsByUserUseCase
import com.simplephotos.domain.usecase.users.GetUserByUserIdUseCase
import com.simplephotos.presentation.base.BaseViewModel
import com.simplephotos.presentation.base.MutableListLiveData
import com.simplephotos.presentation.base.MutableResourceLiveData
import com.simplephotos.presentation.mapper.album.AlbumViewMapper
import com.simplephotos.presentation.mapper.user.UserViewMapper
import com.simplephotos.presentation.models.album.AlbumView
import com.simplephotos.presentation.models.user.UserView
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.kotlin.subscribeBy
import javax.inject.Inject

/**
 * @author Mahmoud Gamal on 15/10/2021.
 */
@HiltViewModel
class UserProfileViewModel @Inject constructor(
    private val getUserUseCase: GetUserByUserIdUseCase,
    private val userMapper: UserViewMapper,
    private val getAlbumsUseCase: GetAlbumsByUserUseCase,
    private val albumMapper: AlbumViewMapper
) : BaseViewModel() {

    private val userLiveData = MutableResourceLiveData<UserView>()
    private val albumsLiveData = MutableListLiveData<AlbumView>()


    fun observeOnUser(
        owner: LifecycleOwner,
        onLoading: () -> Unit,
        onError: (Throwable?) -> Unit,
        onNewData: (UserView) -> Unit
    ) = userLiveData.observe(
        owner = owner,
        onLoading = onLoading,
        onError = onError,
        onNewData = onNewData
    )

    fun observeOnAlbum(
        owner: LifecycleOwner,
        onLoading: () -> Unit,
        onError: (Throwable?) -> Unit,
        onNewData: (List<AlbumView>, List<AlbumView>) -> Unit
    ) = albumsLiveData.observe(
        owner = owner,
        onLoading = onLoading,
        onError = onError,
        onNewData = onNewData
    )

    fun fetchData() {
        getUserInfo()
        getUserAlbums()
    }

    private fun getUserAlbums() {
        albumsLiveData.loading()
        addDisposale(
            createObservableForUserAlbums()
                .subscribeBy(
                    onNext = { albums ->
                        albumsLiveData.setItems(albums.map(albumMapper::mapToPresentation))
                    },
                    onError = { throwable ->
                        throwable.printStackTrace()
                        albumsLiveData.error(throwable)
                    }
                )
        )
    }

    private fun getUserInfo() {
        userLiveData.loading()
        addDisposale(
            createObservableForGetUserInfo()
                .subscribeBy(
                    onNext = { user ->
                        userLiveData.success(userMapper.mapToPresentation(user))
                    },
                    onError = { throwable ->
                        throwable.printStackTrace()
                        userLiveData.error(throwable)
                    }
                )
        )
    }

    private fun createObservableForGetUserInfo(): Observable<User> =
        getUserUseCase
            .getObservable(GetUserByUserIdUseCase.Params.createParams(GlobalConstants.USER_ID))

    private fun createObservableForUserAlbums(): Observable<List<Album>> =
        getAlbumsUseCase
            .getObservable(GetAlbumsByUserUseCase.Params.createParams(GlobalConstants.USER_ID))
}