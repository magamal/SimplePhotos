package com.simplephotos.data.models.album


import com.simplephotos.data.models.Entity

data class AlbumEntity(
    val id: Int?,
    val title: String?,
    val userId: Int?
) : Entity