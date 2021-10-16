package com.simplephotos.domain.models.user


import com.simplephotos.domain.models.Domain

data class User(
    val address: Address?,
    val company: Company?,
    val email: String?,
    val id: Int?,
    val name: String?,
    val phone: String?,
    val username: String?,
    val website: String?
) : Domain