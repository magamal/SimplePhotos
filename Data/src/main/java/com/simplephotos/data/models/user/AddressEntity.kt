package com.simplephotos.data.models.user


import com.simplephotos.data.models.Entity

data class AddressEntity(
    val city: String?,
    val geo: GeoEntity?,
    val street: String?,
    val suite: String?,
    val zipcode: String?
) : Entity