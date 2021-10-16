package com.simplephotos.remote.mappers.user

import com.simplephotos.data.models.user.UserEntity
import com.simplephotos.remote.mappers.ModelMapper
import com.simplephotos.remote.models.user.UserModel
import javax.inject.Inject

/**
 * @author Mahmoud Gamal on 15/10/2021.
 */
class UserModelMapper @Inject constructor(
    private val addressModelMapper: AddressModelMapper,
    private val companyModelMapper: CompanyModelMapper,
) : ModelMapper<UserModel, UserEntity> {
    override fun mapFromModel(model: UserModel?): UserEntity =
        UserEntity(
            address = addressModelMapper?.mapFromModel(model?.address),
            company = companyModelMapper?.mapFromModel(model?.company),
            email = model?.email,
            id = model?.id,
            name = model?.name,
            phone = model?.username,
            website = model?.website,
            username = model?.username
        )

}