package com.simplephotos.presentation.models.user


import com.simplephotos.presentation.models.PresentationModel

data class UserView(
    val address: AddressView?,
    val company: CompanyView?,
    val email: String?,
    val id: Int?,
    val name: String?,
    val phone: String?,
    val username: String?,
    val website: String?
) : PresentationModel