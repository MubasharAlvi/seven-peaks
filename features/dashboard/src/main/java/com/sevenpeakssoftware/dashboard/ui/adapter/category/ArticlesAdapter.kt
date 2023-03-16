package com.sevenpeakssoftware.dashboard.ui.adapter.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sevenpeakssoftware.dashboard.R
import com.sevenpeakssoftware.dashboard.databinding.CarItemsBinding
import com.sevenpeakssoftware.dashboard.domain.models.ArticleModel
import com.sevenpeakssoftware.dashboard.ui.util.load
import com.sevenpeakssoftware.dashboard.ui.util.setTextVisible
import com.sevenpeakssoftware.remote.utils.ApiUtils.BASE_URL

class ArticlesAdapter : ListAdapter<ArticleModel, ArticlesAdapter.ArticleViewHolder>(DiffU()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder =
        ArticleViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.car_items,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }


    inner class ArticleViewHolder(
        private val binding: CarItemsBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(model: ArticleModel) {
            binding.apply {
                headerTitle.setTextVisible(model.title)
                dateTv.setTextVisible(model.dateTime)
                ingressTv.setTextVisible(model.ingress)
                model.image.let {
                    imageviewId.load(BASE_URL + it)
                }
            }
        }
    }
}