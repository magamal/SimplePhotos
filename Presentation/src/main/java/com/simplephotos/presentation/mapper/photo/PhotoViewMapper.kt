package com.simplephotos.presentation.mapper.photo

import com.simplephotos.domain.models.photos.Photo
import com.simplephotos.presentation.mapper.PresentationMapper
import com.simplephotos.presentation.models.photos.PhotoView
import javax.inject.Inject

/**
 * @author Mahmoud Gamal on 15/10/2021.
 */
class PhotoViewMapper @Inject constructor() : PresentationMapper<Photo, PhotoView> {

    override fun mapToPresentation(domain: Photo?): PhotoView =
        PhotoView(
            albumId = domain?.albumId,
            id = domain?.id,
            thumbnailUrl = domain?.thumbnailUrl,
            title = domain?.title,
            url = domain?.title
        )
}