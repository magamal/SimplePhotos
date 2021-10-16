package com.simplephotos.remote.models.user


import com.google.gson.annotations.SerializedName
import com.simplephotos.remote.models.RemoteModel

data class UserModel(
    @SerializedName("address")
    val address: AddressModel?,
    @SerializedName("company")
    val company: CompanyModel?,
    @SerializedName("email")
    val email: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("phone")
    val phone: String?,
    @SerializedName("username")
    val username: String?,
    @SerializedName("website")
    val website: String?
) : RemoteModel