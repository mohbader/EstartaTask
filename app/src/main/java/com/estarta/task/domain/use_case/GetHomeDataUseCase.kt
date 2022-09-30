package com.estarta.task.domain.use_case

import com.estarta.task.data.model.ResultData
import com.estarta.task.domain.repository.HomeRepository

class GetHomeDataUseCase(
    private val homeRepository: HomeRepository
) {

    operator fun invoke(): List<ResultData> {
        return homeRepository.getHomeData()
    }
}