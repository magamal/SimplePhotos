package com.simplephotos.data.models.user


import com.simplephotos.data.models.Entity

data class CompanyEntity(
    val bs: String?,
    val catchPhrase: String?,
    val name: String?
) : Entity