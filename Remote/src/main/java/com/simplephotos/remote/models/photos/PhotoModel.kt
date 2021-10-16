package com.simplephotos.remote.models.photos


import com.google.gson.annotations.SerializedName
import com.simplephotos.remote.models.RemoteModel

data class PhotoModel(
    @SerializedName("albumId")
    val albumId: Int?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("thumbnailUrl")
    val thumbnailUrl: String?,
    @SerializedName("title")
    val title: String?,
    @SerializedName("url")
    val url: String?
) : RemoteModel