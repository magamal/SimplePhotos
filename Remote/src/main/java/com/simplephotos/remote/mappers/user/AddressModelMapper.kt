package com.simplephotos.remote.mappers.user

import com.simplephotos.data.models.user.AddressEntity
import com.simplephotos.remote.mappers.ModelMapper
import com.simplephotos.remote.models.user.AddressModel
import javax.inject.Inject

/**
 * @author Mahmoud Gamal on 15/10/2021.
 */
class AddressModelMapper @Inject constructor(
    private val geoModelMapper: GeoModelMapper
) :
    ModelMapper<AddressModel, AddressEntity> {
    override fun mapFromModel(model: AddressModel?): AddressEntity =
        AddressEntity(
            city = model?.city,
            geo = geoModelMapper.mapFromModel(model?.geo),
            street = model?.street,
            suite = model?.suite,
            zipcode = model?.zipcode,
        )
}