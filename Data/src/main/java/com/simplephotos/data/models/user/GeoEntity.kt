package com.simplephotos.data.models.user


import com.simplephotos.data.models.Entity

data class GeoEntity(
    val lat: String?,
    val lng: String?
) : Entity