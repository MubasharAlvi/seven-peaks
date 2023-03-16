package com.sevenpeakssoftware.dashboard.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ArticleModel (
    val id: Int,
    val title: String?,
    val dateTime: String?,
    val ingress: String?,
    val image: String?
) : Parcelable