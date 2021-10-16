package com.simplephotos.presentation.mapper.user

import com.simplephotos.domain.models.user.User
import com.simplephotos.presentation.mapper.PresentationMapper
import com.simplephotos.presentation.models.user.UserView
import javax.inject.Inject

/**
 * @author Mahmoud Gamal on 15/10/2021.
 */
class UserViewMapper @Inject constructor(
    private val addressMapper: AddressViewMapper,
    private val companyMapper: CompanyViewMapper,
) : PresentationMapper<User, UserView> {
    override fun mapToPresentation(domain: User?): UserView =
        UserView(
            address = addressMapper.mapToPresentation(domain?.address),
            company = companyMapper.mapToPresentation(domain?.company),
            email = domain?.email,
            id = domain?.id,
            name = domain?.name,
            phone = domain?.username,
            website = domain?.website,
            username = domain?.username
        )

}