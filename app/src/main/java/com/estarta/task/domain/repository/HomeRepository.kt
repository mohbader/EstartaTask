package com.estarta.task.domain.repository

import com.estarta.task.data.model.ResultData

interface HomeRepository {

    fun getHomeData(): List<ResultData>
}