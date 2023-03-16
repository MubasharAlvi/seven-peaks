package com.sevenpeakssoftware.dashboard.domain.datasources.remote

import com.sevenpeakssoftware.dashboard.domain.models.ArticleModel
import com.sevenpeakssoftware.remote.utils.Resource
import kotlinx.coroutines.flow.Flow


interface ArticleRemoteDataSource {

    /**
     * Returns all cars
     */
    suspend fun getCars(): Flow<Resource<List<ArticleModel>>>
}