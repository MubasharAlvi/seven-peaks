package com.sevenpeakssoftware.local.daos

import androidx.room.*
import com.sevenpeakssoftware.local.models.ArticleDBModel
import kotlinx.coroutines.flow.Flow


@Dao
interface ArticleDao {

    @Query("SELECT * FROM ArticleDBModel")
    fun getAllCategoriesWithCars(): Flow<List<ArticleDBModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cars: List<ArticleDBModel>)

    @Query("DELETE FROM ArticleDBModel")
    suspend fun deleteAll()

}