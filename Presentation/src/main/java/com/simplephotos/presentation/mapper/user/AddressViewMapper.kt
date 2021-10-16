package com.simplephotos.presentation.mapper.user

import com.simplephotos.domain.models.user.Address
import com.simplephotos.presentation.mapper.PresentationMapper
import com.simplephotos.presentation.models.user.AddressView
import javax.inject.Inject

/**
 * @author Mahmoud Gamal on 15/10/2021.
 */
class AddressViewMapper @Inject constructor(
    private val geoMapper: GeoViewMapper
) : PresentationMapper<Address, AddressView> {

    override fun mapToPresentation(domain: Address?): AddressView =
        AddressView(
            city = domain?.city,
            geo = geoMapper.mapToPresentation(domain?.geo),
            street = domain?.street,
            suite = domain?.suite,
            zipcode = domain?.zipcode,
        )

}