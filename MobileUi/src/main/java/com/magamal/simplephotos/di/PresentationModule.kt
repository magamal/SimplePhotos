package com.magamal.simplephotos.di

import com.simplephotos.data.AlbumsDataRepoImp
import com.simplephotos.data.PhotosDataRepoImp
import com.simplephotos.data.UsersDataRepoImp
import com.simplephotos.data.repository.album.AlbumsDataStore
import com.simplephotos.data.repository.album.AlbumsRemote
import com.simplephotos.data.repository.photo.PhotosDataStore
import com.simplephotos.data.repository.photo.PhotosRemote
import com.simplephotos.data.repository.user.UserDataStore
import com.simplephotos.data.repository.user.UserRemote
import com.simplephotos.data.store.album.AlbumRemoteDataStore
import com.simplephotos.data.store.photo.PhotosRemoteDataStore
import com.simplephotos.data.store.user.UsersRemoteDataStore
import com.simplephotos.domain.executor.PostExecutionThread
import com.simplephotos.domain.repository.AlbumsRepository
import com.simplephotos.domain.repository.PhotosRepository
import com.simplephotos.domain.repository.UsersRepository
import com.simplephotos.presentation.PostExecutionThreadImp
import com.simplephotos.remote.AlbumsRemoteImpl
import com.simplephotos.remote.PhotosRemoteImpl
import com.simplephotos.remote.UserRemoteImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * @author Mahmoud Gamal on 15/10/2021.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class PresentationModule {
    @Binds
    abstract fun bindPostExecutionThread(postExecutionThreadImp: PostExecutionThreadImp): PostExecutionThread

}

