package com.sevenpeakssoftware.dashboard.ui

import com.sevenpeakssoftware.dashboard.domain.models.ArticleModel


sealed class ArticleItemsListStates {
    object Loading : ArticleItemsListStates()
    data class Fetched(val cars : List<ArticleModel>) : ArticleItemsListStates()
}