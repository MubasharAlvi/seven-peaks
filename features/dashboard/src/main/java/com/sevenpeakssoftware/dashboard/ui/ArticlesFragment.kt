package com.sevenpeakssoftware.dashboard.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.sevenpeakssoftware.core.ui.base.BaseFragmentWithVM
import com.sevenpeakssoftware.core.utils.visible
import com.sevenpeakssoftware.dashboard.R
import com.sevenpeakssoftware.dashboard.databinding.FragmentArticleBinding
import com.sevenpeakssoftware.dashboard.ui.adapter.category.ArticlesAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ArticlesFragment :
    BaseFragmentWithVM<FragmentArticleBinding, ArticleViewModel>() {
    private val mViewModel by viewModels<ArticleViewModel>()
    private lateinit var adapter: ArticlesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ArticlesAdapter()
        binding.rvCategories.adapter = adapter

        
        lifecycleScope.launchWhenStarted {
            getViewModel().carState.collect { states ->
                when (states) {
                    is ArticleItemsListStates.Fetched -> {
                        binding.progress.hide()
                        adapter.submitList(states.cars)
                    }
                    is ArticleItemsListStates.Loading -> {
                        binding.progress.visible()
                    }
                }
            }
        }
    }

    override fun getViewModel() = mViewModel

    override fun getLayoutId(): Int = R.layout.fragment_article
}