package com.simplephotos.domain.models.user


import com.simplephotos.domain.models.Domain

data class Address(
    val city: String?,
    val geo: Geo?,
    val street: String?,
    val suite: String?,
    val zipcode: String?
) : Domain