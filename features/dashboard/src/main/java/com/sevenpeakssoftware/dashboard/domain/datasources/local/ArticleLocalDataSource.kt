package com.sevenpeakssoftware.dashboard.domain.datasources.local

import com.sevenpeakssoftware.dashboard.domain.models.ArticleModel
import kotlinx.coroutines.flow.Flow

interface ArticleLocalDataSource {
    /**
     *  Returns list of categories
     */
    suspend fun getCarWhit(): Flow<List<ArticleModel>>

    /**
     * persist categories
     */
    suspend fun saveCarWhit(categories: List<ArticleModel>)

    suspend fun deleteAll()

}