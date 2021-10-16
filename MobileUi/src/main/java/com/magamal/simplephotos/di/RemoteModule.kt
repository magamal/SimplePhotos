package com.magamal.simplephotos.di

import com.simplephotos.data.repository.album.AlbumsRemote
import com.simplephotos.data.repository.photo.PhotosRemote
import com.simplephotos.data.repository.user.UserRemote
import com.simplephotos.remote.AlbumsRemoteImpl
import com.simplephotos.remote.PhotosRemoteImpl
import com.simplephotos.remote.UserRemoteImpl
import com.simplephotos.remote.network.RetrofitClient
import com.simplephotos.remote.service.AlbumService
import com.simplephotos.remote.service.PhotoService
import com.simplephotos.remote.service.UserService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/**
 * @author Mahmoud Gamal on 17/10/2021.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class RemoteModule {
    @Binds
    abstract fun bindAlbumRemote(albumsRemoteImpl: AlbumsRemoteImpl): AlbumsRemote

    @Binds
    abstract fun bindPhotosRemote(photosRemoteImpl: PhotosRemoteImpl): PhotosRemote

    @Binds
    abstract fun bindUsersRemote(userRemoteImpl: UserRemoteImpl): UserRemote
}

@Module
@InstallIn(SingletonComponent::class)
object ProvidesModule {


    @Singleton
    @Provides
    fun provideUserService(): UserService =
        RetrofitClient.create(UserService::class.java)

    @Singleton
    @Provides
    fun provideAlbumService(): AlbumService =
        RetrofitClient.create(AlbumService::class.java)

    @Singleton
    @Provides
    fun providePhotoService(): PhotoService =
        RetrofitClient.create(PhotoService::class.java)
}