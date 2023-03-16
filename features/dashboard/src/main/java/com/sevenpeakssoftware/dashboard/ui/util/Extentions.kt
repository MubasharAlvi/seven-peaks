package com.sevenpeakssoftware.dashboard.ui.util

import android.graphics.drawable.Drawable
import android.graphics.drawable.PictureDrawable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import com.sevenpeakssoftware.dashboard.ui.util.glide_svg.SvgSoftwareLayerSetter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.sevenpeakssoftware.core.utils.invisible
import com.sevenpeakssoftware.dashboard.R
import java.text.SimpleDateFormat
import java.util.*

fun TextView.setTextVisible(text: String?, isGone: Boolean = true) {
    if (text.isNullOrEmpty()) {
        if (isGone) {
            this.hide()
        } else {
            this.invisible()
        }
    } else {
        this.text = text
        this.show()
    }
}

fun View.hide() {
    visibility = View.GONE
}

fun View.show() {
    visibility = View.VISIBLE
}

fun ImageView?.load(
    url: Any?,
    onLoadingFinished: (Drawable?) -> Unit = {},
    @DrawableRes placeholder: Int = R.drawable.ic_icon_round,
    cicular: Boolean = false
) {

    this?.let {
        val listener = object : RequestListener<Drawable> {
            override fun onLoadFailed(
                e: GlideException?,
                model: Any?,
                target: com.bumptech.glide.request.target.Target<Drawable>?,
                isFirstResource: Boolean
            ): Boolean {
                onLoadingFinished.invoke(null)
                return false
            }
//            target: Target<Drawable>?,

            override fun onResourceReady(
                resource: Drawable?,
                model: Any?,
                target: com.bumptech.glide.request.target.Target<Drawable>?,
                dataSource: DataSource?,
                isFirstResource: Boolean
            ): Boolean {
                onLoadingFinished.invoke(resource)
                return false
            }
        }

        var requestBuilder = if ((url as? String)?.endsWith("svg") == true) {
            context?.let {
                Glide.with(it)
                    .`as`(PictureDrawable::class.java)
                    .listener(SvgSoftwareLayerSetter(onLoadingFinished))
                    .load(url)
            }
        } else {
            context?.let {
                Glide.with(it).load(url)
                    .listener(listener)
            }
        }

        if (cicular) {
            requestBuilder = requestBuilder?.circleCrop()
        }

        requestBuilder
            ?.apply(RequestOptions.placeholderOf(placeholder))
            ?.into(it)
    }
}
fun Date.formatToViewDateTimeDefaults(): String{
    val sdf= SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.getDefault())
    return sdf.format(this)
}