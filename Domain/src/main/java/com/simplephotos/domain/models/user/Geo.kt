package com.simplephotos.domain.models.user

import com.simplephotos.domain.models.Domain


data class Geo(
    val lat: String?,
    val lng: String?
) : Domain