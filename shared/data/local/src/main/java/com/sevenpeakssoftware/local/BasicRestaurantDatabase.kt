package com.sevenpeakssoftware.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sevenpeakssoftware.local.daos.ArticleDao
import com.sevenpeakssoftware.local.models.ArticleDBModel

private const val DB_NAME = "car_database"

@Database(entities = [ArticleDBModel::class], version = 1)
abstract class FoodStoreDataBase : RoomDatabase() {
    abstract fun categoryDao(): ArticleDao

    companion object {
        @Volatile
        private var instance: FoodStoreDataBase? = null

        fun getDatabase(context: Context): FoodStoreDataBase =
            instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }

        private fun buildDatabase(appContext: Context) =
            Room.databaseBuilder(appContext, FoodStoreDataBase::class.java, DB_NAME)
                .fallbackToDestructiveMigration()
                .build()
    }
}
