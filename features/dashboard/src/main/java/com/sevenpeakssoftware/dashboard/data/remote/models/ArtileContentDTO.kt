package com.sevenpeakssoftware.dashboard.data.remote.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArtileContentDTO(
    @SerialName("status")
    val status: String?,
    @SerialName("content")
    val content: List<ArticleDTO>?,
    @SerialName("serverTime")
    val serverTime: Int?
)
