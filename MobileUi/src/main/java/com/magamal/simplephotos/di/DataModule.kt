package com.magamal.simplephotos.di

import com.simplephotos.data.AlbumsDataRepoImp
import com.simplephotos.data.PhotosDataRepoImp
import com.simplephotos.data.UsersDataRepoImp
import com.simplephotos.data.repository.album.AlbumsDataStore
import com.simplephotos.data.repository.photo.PhotosDataStore
import com.simplephotos.data.repository.user.UserDataStore
import com.simplephotos.data.store.album.AlbumRemoteDataStore
import com.simplephotos.data.store.photo.PhotosRemoteDataStore
import com.simplephotos.data.store.user.UsersRemoteDataStore
import com.simplephotos.domain.repository.AlbumsRepository
import com.simplephotos.domain.repository.PhotosRepository
import com.simplephotos.domain.repository.UsersRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

/**
 * @author Mahmoud Gamal on 17/10/2021.
 */
@Module
@InstallIn(SingletonComponent::class)
abstract class DataModule {

    @Binds
    abstract fun bindUsersRepository(usersDataRepoImp: UsersDataRepoImp): UsersRepository

    @Binds
    abstract fun bindPhotosRepository(photosDataRepoImp: PhotosDataRepoImp): PhotosRepository

    @Binds
    abstract fun bindAlbumsRepository(albumsDataRepoImp: AlbumsDataRepoImp): AlbumsRepository

    @Binds
    abstract fun bindAlbumRemoteDataStore(albumRemoteDataStore: AlbumRemoteDataStore): AlbumsDataStore

    @Binds
    abstract fun bindPhotosRemoteDataStore(photosRemoteDataStore: PhotosRemoteDataStore): PhotosDataStore

    @Binds
    abstract fun bindUsersRemoteDataStore(usersRemoteDataStore: UsersRemoteDataStore): UserDataStore

}