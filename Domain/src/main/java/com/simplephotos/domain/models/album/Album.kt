package com.simplephotos.domain.models.album

import com.simplephotos.domain.models.Domain

data class Album(
    val id: Int?,
    val title: String?,
    val userId: Int?
) : Domain