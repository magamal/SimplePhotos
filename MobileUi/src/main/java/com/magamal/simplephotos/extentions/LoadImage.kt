package com.magamal.simplephotos.extentions

import android.widget.ImageView
import com.magamal.simplephotos.R
import com.simplephotos.presentation.models.photos.PhotoView
import com.squareup.picasso.Picasso

/**
 * Created by Mahmoud Gamal on 2019-09-07.
 */

fun ImageView.loadImage(url: String?) {
    Picasso
        .get()
        .load(url)
        .placeholder(R.drawable.boarder)
        .error(R.drawable.gray_square)
        .into(this)
}

fun ImageView.loadImage(photo: PhotoView?) {
    loadImage(photo?.thumbnailUrl)
}