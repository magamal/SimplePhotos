package com.simplephotos.data.mappers.album

import com.simplephotos.data.mappers.EntityMapper
import com.simplephotos.data.models.album.AlbumEntity
import com.simplephotos.domain.models.album.Album
import javax.inject.Inject

/**
 * @author Mahmoud Gamal on 15/10/2021.
 */
class AlbumEntityMapper @Inject constructor() : EntityMapper<AlbumEntity, Album> {
    override fun mapToDomain(entity: AlbumEntity?): Album =
        Album(
            id = entity?.id,
            title = entity?.title,
            userId = entity?.userId,
        )
}