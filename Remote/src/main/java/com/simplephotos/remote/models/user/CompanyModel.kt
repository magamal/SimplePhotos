package com.simplephotos.remote.models.user


import com.google.gson.annotations.SerializedName
import com.simplephotos.remote.models.RemoteModel

data class CompanyModel(
    @SerializedName("bs")
    val bs: String?,
    @SerializedName("catchPhrase")
    val catchPhrase: String?,
    @SerializedName("name")
    val name: String?
): RemoteModel