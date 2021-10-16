package com.simplephotos.presentation.mapper.user

import com.simplephotos.domain.models.user.Geo
import com.simplephotos.presentation.mapper.PresentationMapper
import com.simplephotos.presentation.models.user.GeoView
import javax.inject.Inject

/**
 * @author Mahmoud Gamal on 15/10/2021.
 */
class GeoViewMapper @Inject constructor() : PresentationMapper<Geo, GeoView> {
    override fun mapToPresentation(domain: Geo?): GeoView =
        GeoView(
            lat = domain?.lat,
            lng = domain?.lng,
        )
}