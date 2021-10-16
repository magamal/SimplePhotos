package com.simplephotos.remote.mappers.photo

import com.simplephotos.data.models.photos.PhotoEntity
import com.simplephotos.remote.mappers.ModelMapper
import com.simplephotos.remote.models.photos.PhotoModel
import javax.inject.Inject

/**
 * @author Mahmoud Gamal on 15/10/2021.
 */
class PhotoModelMapper @Inject constructor() : ModelMapper<PhotoModel, PhotoEntity> {
    override fun mapFromModel(model: PhotoModel?): PhotoEntity =
        PhotoEntity(
            albumId = model?.albumId,
            id = model?.id,
            thumbnailUrl = model?.thumbnailUrl,
            title = model?.title,
            url = model?.title
        )
}