package com.sevenpeakssoftware.dashboard.domain.repository

import com.sevenpeakssoftware.core.repoutils.manageDataSource
import com.sevenpeakssoftware.dashboard.domain.datasources.local.ArticleLocalDataSource
import com.sevenpeakssoftware.dashboard.domain.datasources.remote.ArticleRemoteDataSource
import com.sevenpeakssoftware.dashboard.domain.models.ArticleModel
import com.sevenpeakssoftware.remote.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    private val remoteDataSource: ArticleRemoteDataSource,
    private val categoryPDS: ArticleLocalDataSource
) : ArticleRepository {

    override suspend fun getAllCars(): Flow<Resource<List<ArticleModel>>> =
        manageDataSource(
            getDataFromPersistence = { categoryPDS.getCarWhit() },
            getDataFromServer = { remoteDataSource.getCars() },
            updateLocal = {
                clearAll()
                updateLocal(it)
            }
        )

    private suspend fun clearAll() {
        categoryPDS.deleteAll()
    }

    override suspend fun updateLocal(categoriesWithProducts: List<ArticleModel>) {
        categoryPDS.saveCarWhit(categoriesWithProducts)
    }
}