package com.example.skcbinterview

import android.text.TextUtils
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object RecyclerViewBindingAdapter {

    @BindingAdapter("app:imgUrl")
    @JvmStatic
    fun load(imageView: ImageView, url: String?) {
        if(url != null) Glide.with(imageView.context).load(url).into(imageView)
    }

}