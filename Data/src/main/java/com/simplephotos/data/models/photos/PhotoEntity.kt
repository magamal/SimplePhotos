package com.simplephotos.data.models.photos


import com.simplephotos.data.models.Entity

data class PhotoEntity(
    val albumId: Int?,
    val id: Int?,
    val thumbnailUrl: String?,
    val title: String?,
    val url: String?
) : Entity