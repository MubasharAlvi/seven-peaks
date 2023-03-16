package com.sevenpeakssoftware.dashboard.data

import com.sevenpeakssoftware.dashboard.data.Response.*
import com.sevenpeakssoftware.dashboard.domain.models.ArticleModel
import com.sevenpeakssoftware.dashboard.utils.toDomainModel
import com.sevenpeakssoftware.remote.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

fun getCategories(): List<ArticleModel> = getCategoriesDTO().toDomainModel()


const val ERROR_MESSAGE = "Network Error"
fun getCategoriesResourceFlow(resource: Response): Flow<Resource<List<ArticleModel>>> =
    flow {
        when (resource) {
            Valid -> {
                emit(Resource.Valid(getCategories()))
            }
            Invalid -> {
                emit(Resource.Invalid(ERROR_MESSAGE))
            }
            Loading -> {
                emit(Resource.Loading())
            }
        }
    }

enum class Response {
    Valid,
    Invalid,
    Loading
}