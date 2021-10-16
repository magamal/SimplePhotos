package com.simplephotos.data.mappers.user

import com.simplephotos.data.mappers.EntityMapper
import com.simplephotos.data.models.user.UserEntity
import com.simplephotos.domain.models.user.User
import javax.inject.Inject

/**
 * @author Mahmoud Gamal on 15/10/2021.
 */
class UserEntityMapper @Inject constructor(
    private val addressMapper: AddressEntityMapper,
    private val companyMapper: CompanyEntityMapper,
) : EntityMapper<UserEntity, User> {

    override fun mapToDomain(entity: UserEntity?): User = User(
        address = addressMapper.mapToDomain(entity?.address),
        company = companyMapper.mapToDomain(entity?.company),
        email = entity?.email,
        id = entity?.id,
        name = entity?.name,
        phone = entity?.username,
        website = entity?.website,
        username = entity?.username
    )

}