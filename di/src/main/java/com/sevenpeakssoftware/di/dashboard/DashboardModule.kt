package com.sevenpeakssoftware.di.dashboard

import com.sevenpeakssoftware.dashboard.data.local.datasources.ArticleLocalDataSourceImpl
import com.sevenpeakssoftware.dashboard.data.remote.datasources.ArticleRemoteDataSourceImpl
import com.sevenpeakssoftware.dashboard.domain.datasources.local.ArticleLocalDataSource
import com.sevenpeakssoftware.dashboard.domain.datasources.remote.ArticleRemoteDataSource
import com.sevenpeakssoftware.dashboard.domain.repository.ArticleRepository
import com.sevenpeakssoftware.dashboard.domain.repository.ArticleRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object DashboardModule {

    @Provides
    @ViewModelScoped
    fun provideRemoteDataSource(
        dataSourceImpl: ArticleRemoteDataSourceImpl
    ): ArticleRemoteDataSource {
        return dataSourceImpl
    }

    @Provides
    @ViewModelScoped
    fun provideWeatherRepository(
        categoryRepositoryImpl: ArticleRepositoryImpl
    ): ArticleRepository = categoryRepositoryImpl

    @Provides
    @ViewModelScoped
    fun provideCategoryPersistenceDataSource(
        categoryLocalDataSource: ArticleLocalDataSourceImpl
    ): ArticleLocalDataSource {
        return categoryLocalDataSource
    }

//    @Provides
//    @ViewModelScoped
//    fun provideProductPersistenceDataSource(
//        productLocalDataSourceImpl: CarLocalDataSourceImpl
//    ): CarLocalDataSource {
//        return productLocalDataSourceImpl
//    }
}