package com.simplephotos.presentation.mapper.user

import com.simplephotos.domain.models.user.Company
import com.simplephotos.presentation.mapper.PresentationMapper
import com.simplephotos.presentation.models.user.CompanyView
import javax.inject.Inject

/**
 * @author Mahmoud Gamal on 15/10/2021.
 */
class CompanyViewMapper @Inject constructor() : PresentationMapper<Company, CompanyView> {

    override fun mapToPresentation(domain: Company?): CompanyView = CompanyView(
        bs = domain?.bs,
        catchPhrase = domain?.catchPhrase,
        name = domain?.name,
    )


}