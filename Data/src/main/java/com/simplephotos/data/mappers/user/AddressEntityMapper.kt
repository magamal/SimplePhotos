package com.simplephotos.data.mappers.user

import com.simplephotos.data.mappers.EntityMapper
import com.simplephotos.data.models.user.AddressEntity
import com.simplephotos.domain.models.user.Address
import javax.inject.Inject

/**
 * @author Mahmoud Gamal on 15/10/2021.
 */
class AddressEntityMapper @Inject constructor(
    private val geoEntityMapper: GeoEntityMapper
) : EntityMapper<AddressEntity, Address> {
    override fun mapToDomain(entity: AddressEntity?): Address =
        Address(
            city = entity?.city,
            geo = geoEntityMapper.mapToDomain(entity?.geo),
            street = entity?.street,
            suite = entity?.suite,
            zipcode = entity?.zipcode,
        )

}