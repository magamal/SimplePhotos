package com.simplephotos.data.mappers.user

import com.simplephotos.data.mappers.EntityMapper
import com.simplephotos.data.models.user.GeoEntity
import com.simplephotos.domain.models.user.Geo
import javax.inject.Inject

/**
 * @author Mahmoud Gamal on 15/10/2021.
 */
class GeoEntityMapper @Inject constructor() : EntityMapper<GeoEntity, Geo> {

    override fun mapToDomain(entity: GeoEntity?): Geo =
        Geo(
            lat = entity?.lat,
            lng = entity?.lng,
        )
}