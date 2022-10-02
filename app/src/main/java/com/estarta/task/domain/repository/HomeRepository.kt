package com.estarta.task.domain.repository

import com.estarta.task.data.model.HomeData

interface HomeRepository {

   suspend fun getHomeData(): HomeData
}