package com.sevenpeakssoftware.dashboard.ui.adapter.category

import androidx.recyclerview.widget.DiffUtil
import com.sevenpeakssoftware.dashboard.domain.models.ArticleModel


class DiffU : DiffUtil.ItemCallback<ArticleModel>() {

    override fun areItemsTheSame(oldItem: ArticleModel, newItem: ArticleModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: ArticleModel, newItem: ArticleModel): Boolean {
        return oldItem == newItem
    }


}