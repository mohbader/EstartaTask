package com.estarta.task.domain.repository

import com.estarta.task.data.data_source.HomeRemoteDataSource
import com.estarta.task.data.model.ResultData

class HomeRepositoryImp(
    private val homeRemoteDataSource: HomeRemoteDataSource
) : HomeRepository {

    override fun getHomeData(): List<ResultData> {
        return homeRemoteDataSource.getHomeData()
    }

}