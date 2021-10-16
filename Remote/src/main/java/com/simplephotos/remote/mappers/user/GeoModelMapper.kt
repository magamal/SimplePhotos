package com.simplephotos.remote.mappers.user

import com.simplephotos.data.models.user.GeoEntity
import com.simplephotos.remote.mappers.ModelMapper
import com.simplephotos.remote.models.user.GeoModel
import javax.inject.Inject

/**
 * @author Mahmoud Gamal on 15/10/2021.
 */
class GeoModelMapper @Inject constructor() : ModelMapper<GeoModel, GeoEntity> {
    override fun mapFromModel(model: GeoModel?): GeoEntity =
        GeoEntity(
            lat = model?.lat,
            lng = model?.lng,
        )
}