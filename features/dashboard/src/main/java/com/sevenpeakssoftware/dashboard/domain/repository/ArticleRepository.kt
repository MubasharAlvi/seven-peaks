package com.sevenpeakssoftware.dashboard.domain.repository

import com.sevenpeakssoftware.dashboard.domain.models.ArticleModel
import com.sevenpeakssoftware.remote.utils.Resource
import kotlinx.coroutines.flow.Flow

interface ArticleRepository {

    suspend fun getAllCars(): Flow<Resource<List<ArticleModel>>>

    suspend fun updateLocal(categoriesWithProducts: List<ArticleModel>)
}