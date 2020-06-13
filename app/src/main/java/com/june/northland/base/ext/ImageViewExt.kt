package com.june.northland.base.ext

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop

fun ImageView.loadAvatar(resourceId: Int) {
    Glide.with(this).load(resourceId).transform(CircleCrop()).into(this)
}