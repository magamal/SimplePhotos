package com.simplephotos.presentation.models.photos

import android.os.Parcelable
import com.simplephotos.presentation.models.PresentationModel
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PhotoView(
    val albumId: Int?,
    val id: Int?,
    val thumbnailUrl: String?,
    val title: String?,
    val url: String?
) : PresentationModel, Parcelable