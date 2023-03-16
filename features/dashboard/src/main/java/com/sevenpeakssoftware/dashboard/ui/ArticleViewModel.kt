package com.sevenpeakssoftware.dashboard.ui

import androidx.lifecycle.viewModelScope
import com.sevenpeakssoftware.core.ui.base.BaseViewModel
import com.sevenpeakssoftware.dashboard.domain.models.ArticleModel
import com.sevenpeakssoftware.dashboard.domain.usecases.ArticleUseCase
import com.sevenpeakssoftware.remote.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleViewModel @Inject constructor(
    private val categoryUseCase: ArticleUseCase
) : BaseViewModel() {
    private val carList = MutableStateFlow(listOf<ArticleModel>())
    val carState = MutableStateFlow<ArticleItemsListStates>(ArticleItemsListStates.Loading)



    init {
        getCategoriesWithProducts()
    }

    private fun getCategoriesWithProducts() {
        viewModelScope.launch {
            categoryUseCase.getAllCars().collect { response ->
                when (response) {
                    is Resource.Valid -> {
                        response.data.let {
                            carState.value = ArticleItemsListStates.Fetched(it)
                        }
                    }
                    is Resource.Invalid -> sendError(response.message)
                    is Resource.Loading -> carState.value = ArticleItemsListStates.Loading
                }
            }
        }
    }


}