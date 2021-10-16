package com.simplephotos.data.mappers.user

import com.simplephotos.data.mappers.EntityMapper
import com.simplephotos.data.models.user.CompanyEntity
import com.simplephotos.domain.models.user.Company
import javax.inject.Inject

/**
 * @author Mahmoud Gamal on 15/10/2021.
 */
class CompanyEntityMapper @Inject constructor() : EntityMapper<CompanyEntity, Company> {

    override fun mapToDomain(entity: CompanyEntity?): Company = Company(
        bs = entity?.bs,
        catchPhrase = entity?.catchPhrase,
        name = entity?.name,
    )

}