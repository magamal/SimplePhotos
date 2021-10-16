package com.simplephotos.data.mappers.photo

import com.simplephotos.data.mappers.EntityMapper
import com.simplephotos.data.models.photos.PhotoEntity
import com.simplephotos.domain.models.photos.Photo
import javax.inject.Inject

/**
 * @author Mahmoud Gamal on 15/10/2021.
 */
class PhotoEntityMapper @Inject constructor() : EntityMapper<PhotoEntity, Photo> {

    override fun mapToDomain(entity: PhotoEntity?): Photo =
        Photo(
            albumId = entity?.albumId,
            id = entity?.id,
            thumbnailUrl = entity?.thumbnailUrl,
            title = entity?.title,
            url = entity?.title
        )
}