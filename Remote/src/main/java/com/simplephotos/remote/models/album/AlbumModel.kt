package com.simplephotos.remote.models.album


import com.google.gson.annotations.SerializedName
import com.simplephotos.remote.models.RemoteModel

data class AlbumModel(
    @SerializedName("id")
    val id: Int?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("userId")
    val userId: Int?
) : RemoteModel