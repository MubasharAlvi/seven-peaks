package com.sevenpeakssoftware.dashboard.data.remote.datasources

import com.sevenpeakssoftware.dashboard.data.remote.api.ApiService
import com.sevenpeakssoftware.dashboard.domain.datasources.remote.ArticleRemoteDataSource
import com.sevenpeakssoftware.dashboard.domain.models.ArticleModel
import com.sevenpeakssoftware.dashboard.utils.toDomainModel
import com.sevenpeakssoftware.remote.datasource.BaseRemoteDataSource
import com.sevenpeakssoftware.remote.utils.Resource
import com.sevenpeakssoftware.remote.utils.transform
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ArticleRemoteDataSourceImpl @Inject constructor(
    private val apiClient: ApiService
) : ArticleRemoteDataSource, BaseRemoteDataSource() {

    override suspend fun getCars(): Flow<Resource<List<ArticleModel>>> = safeApiCall {
        apiClient.getCarItems()
    }.map { it ->
        it.transform {
            it.toDomainModel()
        }
    }
}
