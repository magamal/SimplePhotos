package com.simplephotos.presentation.models.user

import com.simplephotos.presentation.models.PresentationModel


data class GeoView(
    val lat: String?,
    val lng: String?
) : PresentationModel