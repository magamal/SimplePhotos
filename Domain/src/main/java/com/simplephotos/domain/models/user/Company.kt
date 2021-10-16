package com.simplephotos.domain.models.user


import com.simplephotos.domain.models.Domain

data class Company(
    val bs: String?,
    val catchPhrase: String?,
    val name: String?
) : Domain