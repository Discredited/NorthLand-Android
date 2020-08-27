package com.june.northland.base.ext

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.june.northland.R

fun ImageView.loadAvatar(resourceId: Int) {
    Glide.with(this).load(resourceId).transform(CircleCrop()).into(this)
}

fun ImageView.loadAvatar(avatar: String) {
    val corners = resources.getDimensionPixelSize(R.dimen.dp_5)
    Glide.with(this).load(avatar).transform(RoundedCorners(corners)).into(this)
}

fun ImageView.loadImage(url: String) {
    Glide.with(this).load(url).transform(CenterCrop()).into(this)
}