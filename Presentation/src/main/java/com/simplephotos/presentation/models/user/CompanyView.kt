package com.simplephotos.presentation.models.user


import com.simplephotos.presentation.models.PresentationModel

data class CompanyView(
    val bs: String?,
    val catchPhrase: String?,
    val name: String?
) : PresentationModel