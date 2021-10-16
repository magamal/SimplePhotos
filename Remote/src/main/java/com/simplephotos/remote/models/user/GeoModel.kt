package com.simplephotos.remote.models.user


import com.google.gson.annotations.SerializedName
import com.simplephotos.remote.models.RemoteModel

data class GeoModel(
    @SerializedName("lat")
    val lat: String?,
    @SerializedName("lng")
    val lng: String?
) : RemoteModel