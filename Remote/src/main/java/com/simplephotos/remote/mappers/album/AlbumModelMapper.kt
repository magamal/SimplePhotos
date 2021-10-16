package com.simplephotos.remote.mappers.album

import com.simplephotos.data.models.album.AlbumEntity
import com.simplephotos.remote.mappers.ModelMapper
import com.simplephotos.remote.models.album.AlbumModel
import javax.inject.Inject

/**
 * @author Mahmoud Gamal on 15/10/2021.
 */
class AlbumModelMapper @Inject constructor() : ModelMapper<AlbumModel, AlbumEntity> {
    override fun mapFromModel(model: AlbumModel?): AlbumEntity =
        AlbumEntity(
            id = model?.id,
            title = model?.title,
            userId = model?.userId,
        )
}