package com.simplephotos.presentation.mapper

import com.simplephotos.domain.models.Domain
import com.simplephotos.presentation.models.PresentationModel

/**
 * This interface is used when you want to create a new Mapper
 * @E : is for Entity model (in clientInfo layer)
 * @D : is for Domain model
 */
interface PresentationMapper<D : Domain, V : PresentationModel> {
    fun mapToPresentation(domain: D?): V
}