package com.simplephotos.presentation.models.album

import android.os.Parcelable
import com.simplephotos.presentation.models.PresentationModel
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AlbumView(
    val id: Int?,
    val title: String?,
    val userId: Int?
) : PresentationModel, Parcelable