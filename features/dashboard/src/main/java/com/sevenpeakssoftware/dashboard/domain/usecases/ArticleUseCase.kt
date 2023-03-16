package com.sevenpeakssoftware.dashboard.domain.usecases

import com.sevenpeakssoftware.dashboard.domain.repository.ArticleRepository

import javax.inject.Inject

class ArticleUseCase @Inject constructor(
    private val articleRepository: ArticleRepository
) {
    suspend fun getAllCars() = articleRepository.getAllCars()
}