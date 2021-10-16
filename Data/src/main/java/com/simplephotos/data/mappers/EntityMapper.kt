package com.simplephotos.data.mappers

import com.simplephotos.data.models.Entity
import com.simplephotos.domain.models.Domain

/**
 * This interface is used when you want to create a new Mapper
 * @E : is for Entity model (in data layer)
 * @D : is for Domain model
 */
interface EntityMapper<E : Entity, D : Domain> {
    fun mapToDomain(entity: E?): D // to Domain (Domain Module)
}