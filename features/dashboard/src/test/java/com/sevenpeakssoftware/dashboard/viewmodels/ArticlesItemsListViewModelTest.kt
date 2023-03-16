package com.sevenpeakssoftware.dashboard.viewmodels

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth.assertThat
import com.sevenpeakssoftware.core.ui.base.BaseViewModel
import com.sevenpeakssoftware.dashboard.data.ERROR_MESSAGE
import com.sevenpeakssoftware.dashboard.data.Response
import com.sevenpeakssoftware.dashboard.data.getCategories
import com.sevenpeakssoftware.dashboard.data.getCategoriesResourceFlow
import com.sevenpeakssoftware.dashboard.domain.usecases.ArticleUseCase
import com.sevenpeakssoftware.dashboard.ui.ArticleItemsListStates
import com.sevenpeakssoftware.dashboard.ui.ArticleViewModel
import com.sevenpeakssoftware.dashboard.utils.MainCoroutinesRule
import com.sevenpeakssoftware.remote.utils.Resource
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class ArticlesItemsListViewModelTest {
    private val articleUseCase: ArticleUseCase = mockk()
    private lateinit var viewModel: ArticleViewModel

    @ExperimentalCoroutinesApi
    @get:Rule
    var coroutinesRule = MainCoroutinesRule()

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setup() {
        viewModel = ArticleViewModel(articleUseCase)
    }

    @Test
    fun `get categories with products when server response valid`() = runBlockingTest {
        coEvery { articleUseCase.getAllCars() } returns getCategoriesResourceFlow(Response.Valid)
        viewModel.carState.take(2).toList().run {
            assertThat(get(0)).isEqualTo(ArticleItemsListStates.Loading)
            assertThat(get(1)).isEqualTo(
                ArticleItemsListStates.Fetched(
                    getCategories()
                )
            )
        }

    }

    @Test
    fun `get categories with products when server response Invalid and db have data`() =
        runBlockingTest {
            coEvery {
                articleUseCase.getAllCars()
            } returns getCategoriesResourceFlow(Response.Invalid) andThen
                    getCategoriesResourceFlow(Response.Valid)
            viewModel.baseEvents.first().let {
                assertThat(it).isEqualTo(BaseViewModel.BaseEvent.EventError(ERROR_MESSAGE))
            }

            viewModel.carState.first().let {
                assertThat(it).isEqualTo(
                    ArticleItemsListStates.Fetched(
                        getCategories()
                    )
                )

            }
        }

    @Test
    fun `get categories with products when server response Invalid and db is empty`() =
        runTest {
            coEvery {
                articleUseCase.getAllCars()
            } returns getCategoriesResourceFlow(Response.Invalid) andThen
                    flow { emit(Resource.Valid(listOf())) }
            viewModel.baseEvents.first().let {
                assertThat(it).isEqualTo(BaseViewModel.BaseEvent.EventError(ERROR_MESSAGE))
            }
        }

}