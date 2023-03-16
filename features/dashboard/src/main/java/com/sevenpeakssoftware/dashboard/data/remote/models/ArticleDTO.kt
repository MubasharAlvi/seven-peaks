package com.sevenpeakssoftware.dashboard.data.remote.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticleDTO(
    @SerialName("id")
    val id: Int,
    @SerialName("title")
    val title: String?,
    @SerialName("dateTime")
    val dateTime: String?,
    @SerialName("tags")
    val tags: List<String>?,
    @SerialName("content")
    val content: List<ArticleContentTypeDTO>?,
    @SerialName("ingress")
    val ingress: String?,
    @SerialName("image")
    val image: String?,
    @SerialName("created")
    val created: Int?,
    @SerialName("changed")
    val changed: Int?
)
