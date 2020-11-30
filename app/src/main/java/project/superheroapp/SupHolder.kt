package com.app.superheroapp2

import android.widget.ImageView
import android.media.Image
import com.squareup.picasso.Picasso

fun ImageView.fromUrl(url:String){
    Picasso.get().load(url).into(this)
}