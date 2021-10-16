package com.simplephotos.remote.mappers.user

import com.simplephotos.data.models.user.CompanyEntity
import com.simplephotos.remote.mappers.ModelMapper
import com.simplephotos.remote.models.user.CompanyModel
import javax.inject.Inject

/**
 * @author Mahmoud Gamal on 15/10/2021.
 */
class CompanyModelMapper @Inject constructor() : ModelMapper<CompanyModel, CompanyEntity> {
    override fun mapFromModel(model: CompanyModel?): CompanyEntity =
        CompanyEntity(
            bs = model?.bs,
            catchPhrase = model?.catchPhrase,
            name = model?.name,
        )
}