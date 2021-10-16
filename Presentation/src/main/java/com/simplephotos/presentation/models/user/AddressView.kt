package com.simplephotos.presentation.models.user


import com.simplephotos.presentation.models.PresentationModel

data class AddressView(
    val city: String?,
    val geo: GeoView?,
    val street: String?,
    val suite: String?,
    val zipcode: String?
) : PresentationModel