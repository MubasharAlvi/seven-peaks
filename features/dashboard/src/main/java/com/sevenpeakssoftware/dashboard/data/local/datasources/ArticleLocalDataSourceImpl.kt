package com.sevenpeakssoftware.dashboard.data.local.datasources

import com.sevenpeakssoftware.dashboard.domain.datasources.local.ArticleLocalDataSource
import com.sevenpeakssoftware.dashboard.domain.models.ArticleModel
import com.sevenpeakssoftware.dashboard.utils.toDomainModel
import com.sevenpeakssoftware.local.daos.ArticleDao
import com.sevenpeakssoftware.dashboard.utils.toDBModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ArticleLocalDataSourceImpl @Inject constructor(
    private val categoryDao: ArticleDao
) : ArticleLocalDataSource {

    override suspend fun getCarWhit(): Flow<List<ArticleModel>> {
        return categoryDao.getAllCategoriesWithCars()
            .distinctUntilChanged()
            .map {
                it.toDomainModel()
            }
    }

    override suspend fun saveCarWhit(categories: List<ArticleModel>) {
        categoryDao.insert(categories.toDBModel())
    }

    override suspend fun deleteAll() {
        categoryDao.deleteAll()
    }

}