package com.sevenpeakssoftware.local.models


import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ArticleDBModel(
    @PrimaryKey
    val id: Int,
    val title: String?,
    val dateTime: String?,
    val ingress: String?,
    val image: String?
)