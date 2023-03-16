package com.sevenpeakssoftware.dashboard.utils

import com.sevenpeakssoftware.dashboard.domain.models.*
import com.sevenpeakssoftware.local.models.ArticleDBModel

/**
 * Mapping Domain Models to DB Models
 */

@JvmName("toDomainModelCarDBModel")
fun ArticleModel.toDBModel() : ArticleDBModel{
    return ArticleDBModel(
        id = id,
        title = title,
        dateTime = dateTime,
        ingress = ingress,
        image = image
    )
}

fun List<ArticleModel>.toDBModel() = map {
    it.toDBModel()
}

