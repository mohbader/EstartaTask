package com.estarta.task.domain.use_case

import com.estarta.task.data.model.HomeData
import com.estarta.task.domain.repository.HomeRepository

class GetHomeDataUseCase(
    private val homeRepository: HomeRepository
) {

    suspend fun getHomeData(): HomeData {
        return homeRepository.getHomeData()
    }
}