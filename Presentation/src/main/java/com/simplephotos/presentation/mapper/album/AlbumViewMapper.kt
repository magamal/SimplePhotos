package com.simplephotos.presentation.mapper.album

import com.simplephotos.domain.models.album.Album
import com.simplephotos.presentation.mapper.PresentationMapper
import com.simplephotos.presentation.models.album.AlbumView
import javax.inject.Inject

/**
 * @author Mahmoud Gamal on 15/10/2021.
 */
class AlbumViewMapper @Inject constructor() : PresentationMapper<Album, AlbumView> {
    override fun mapToPresentation(domain: Album?): AlbumView =
        AlbumView(
            id = domain?.id,
            title = domain?.title,
            userId = domain?.userId,
        )
}