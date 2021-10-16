package com.simplephotos.domain.models.photos

import com.simplephotos.domain.models.Domain


data class Photo(
    val albumId: Int?,
    val id: Int?,
    val thumbnailUrl: String?,
    val title: String?,
    val url: String?
) : Domain