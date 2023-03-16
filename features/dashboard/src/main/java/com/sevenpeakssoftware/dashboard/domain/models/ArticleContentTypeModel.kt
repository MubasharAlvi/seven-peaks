package com.sevenpeakssoftware.dashboard.domain.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ArticleContentTypeModel(
val type:String?,
val subject : String?,
val description: String?
): Parcelable
