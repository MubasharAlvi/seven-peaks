package com.sevenpeakssoftware.dashboard.data.remote.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticleContentTypeDTO(
    @SerialName("type")
    val type: String?,
    @SerialName("subject")
    val subject: String?,
    @SerialName("description")
    val description: String?
)