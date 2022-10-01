package com.estarta.task.domain.repository

import com.estarta.task.data.data_source.HomeRemoteDataSource
import com.estarta.task.data.model.HomeData

class HomeRepositoryImp(
    private val homeRemoteDataSource: HomeRemoteDataSource
) : HomeRepository {

    override fun getHomeData(): HomeData {
        return homeRemoteDataSource.getHomeData()
    }

}