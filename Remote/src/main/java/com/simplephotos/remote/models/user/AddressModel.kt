package com.simplephotos.remote.models.user


import com.google.gson.annotations.SerializedName
import com.simplephotos.remote.models.RemoteModel

data class AddressModel(
    @SerializedName("city")
    val city: String?,
    @SerializedName("geo")
    val geo: GeoModel?,
    @SerializedName("street")
    val street: String?,
    @SerializedName("suite")
    val suite: String?,
    @SerializedName("zipcode")
    val zipcode: String?
): RemoteModel