package com.sevenpeakssoftware.dashboard.utils

import com.sevenpeakssoftware.dashboard.data.remote.models.ArtileContentDTO
import com.sevenpeakssoftware.dashboard.data.remote.models.ArticleDTO
import com.sevenpeakssoftware.dashboard.domain.models.ArticleModel
import com.sevenpeakssoftware.local.models.ArticleDBModel

/**
 * Mapping DBModels to Domain Models
 */

@JvmName("toDomainModelCarsModel")
fun ArticleDTO.toDomainModel(): ArticleModel {
    return ArticleModel(
        id = id,
        title = title,
        dateTime = dateTime,
        ingress = ingress,
        image = image
    )
}

@JvmName("toDomainModelCarDBModel")
fun List<ArticleDBModel>.toDomainModel() : List<ArticleModel> = this.map {
    it.toDomainModel()
}
fun ArticleDBModel.toDomainModel() = ArticleModel(
    id = id,
    title = title,
    dateTime = dateTime,
    ingress = ingress,
    image = image
)



fun List<ArticleDTO>.toDomainModel() : List<ArticleModel> = map {
    it.toDomainModel()
}

fun ArtileContentDTO.toDomainModel() = content?.toDomainModel() ?: listOf()


